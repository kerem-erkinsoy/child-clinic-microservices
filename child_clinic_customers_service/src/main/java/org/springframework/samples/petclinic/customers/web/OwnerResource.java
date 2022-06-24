package org.springframework.samples.petclinic.customers.web;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.customers.model.Parent;
import org.springframework.samples.petclinic.customers.model.ParentRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RequestMapping("/owners")
@RestController
@Timed("petclinic.owner")
@RequiredArgsConstructor
@Slf4j
class OwnerResource {

    private final ParentRepository parentRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parent createOwner(@Valid @RequestBody Parent parent) {
        return parentRepository.save(parent);
    }

    @GetMapping(value = "/{ownerId}")
    public Optional<Parent> findOwner(@PathVariable("ownerId") @Min(1) int ownerId) {
        return parentRepository.findById(ownerId);
    }

    @GetMapping
    public List<Parent> findAll() {
        return parentRepository.findAll();
    }

    @PutMapping(value = "/{ownerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(@PathVariable("ownerId") @Min(1) int ownerId, @Valid @RequestBody Parent parentRequest) {
        final Optional<Parent> owner = parentRepository.findById(ownerId);
        final Parent parentModel = owner.orElseThrow(() -> new ResourceNotFoundException("Parent " + ownerId + " not found"));

        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        parentModel.setFirstName(parentRequest.getFirstName());
        parentModel.setLastName(parentRequest.getLastName());
        parentModel.setCity(parentRequest.getCity());
        parentModel.setAddress(parentRequest.getAddress());
        parentModel.setTelephone(parentRequest.getTelephone());
        log.info("Saving owner {}", parentModel);
        parentRepository.save(parentModel);
    }
}
