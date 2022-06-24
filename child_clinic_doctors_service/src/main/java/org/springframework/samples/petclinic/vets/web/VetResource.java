
package org.springframework.samples.petclinic.vets.web;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.samples.petclinic.vets.model.Doctor;
import org.springframework.samples.petclinic.vets.model.DoctorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vets")
@RestController
@RequiredArgsConstructor
class VetResource {

    private final DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> showResourcesVetList() {
        return doctorRepository.findAll();
    }
}
