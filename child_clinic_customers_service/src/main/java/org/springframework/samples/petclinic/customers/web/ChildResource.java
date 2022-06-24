
package org.springframework.samples.petclinic.customers.web;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.customers.model.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@Timed("petclinic.pet")
@RequiredArgsConstructor
@Slf4j
class ChildResource {

    private final ChildrenRepository childrenRepository;
    private final ParentRepository parentRepository;


    @GetMapping("/petTypes")
    public List<DiseaseType> getPetTypes() {
        return childrenRepository.findPetTypes();
    }

    @PostMapping("/owners/{ownerId}/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public Child processCreationForm(
        @RequestBody ChildRequest childRequest,
        @PathVariable("ownerId") @Min(1) int ownerId) {

        final Optional<Parent> optionalOwner = parentRepository.findById(ownerId);
        Parent parent = optionalOwner.orElseThrow(() -> new ResourceNotFoundException("Parent " + ownerId + " not found"));

//        final Child child = new Child();
        Child child = new Child();
        parent.addPet(child);
        return save(child, childRequest);
    }

    @PutMapping("/owners/*/pets/{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processUpdateForm(@RequestBody ChildRequest childRequest) {
        int petId = childRequest.getId();
        Child child = findPetById(petId);
        save(child, childRequest);
    }

    private Child save(final Child child, final ChildRequest childRequest) {

        child.setName(childRequest.getName());
        child.setBirthDate(childRequest.getBirthDate());
        child.setGender(childRequest.getGender());
        System.out.println("child gender: " + child.getGender());
        childrenRepository.findPetTypeById(childRequest.getTypeId())
            .ifPresent(child::setType);

        log.info("Saving child {}", child);
        log.info("Parent: " + child.getOwner().getPets().get(0).getGender());
        log.info("Parent: " + child.getOwner().getPets().get(0).getName());
        return childrenRepository.save(child);
    }

    @GetMapping("owners/*/pets/{petId}")
    public ChildDetails findPet(@PathVariable("petId") int childId) {
        return new ChildDetails(findPetById(childId));
    }


    private Child findPetById(int childId) {
        Optional<Child> pet = childrenRepository.findById(childId);
        if (!pet.isPresent()) {
            throw new ResourceNotFoundException("Child " + childId + " not found");
        }
        return pet.get();
    }

}
