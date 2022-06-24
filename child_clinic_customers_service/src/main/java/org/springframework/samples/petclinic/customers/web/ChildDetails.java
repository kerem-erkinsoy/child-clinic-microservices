
package org.springframework.samples.petclinic.customers.web;

import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.customers.model.Child;
import org.springframework.samples.petclinic.customers.model.DiseaseType;


@Data
class ChildDetails {

    private long id;

    private String name;

    private String owner;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private DiseaseType type;

    private String gender;

    ChildDetails(Child child) {
        this.id = child.getId();
        this.name = child.getName();
        this.owner = child.getOwner().getFirstName() + " " + child.getOwner().getLastName();
        this.birthDate = child.getBirthDate();
        this.type = child.getType();
        this.gender = child.getGender();
    }
}
