package org.springframework.samples.petclinic.customers.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "owners")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Getter
    @Setter
    @Column(name = "address")
    @NotBlank
    private String address;

    @Getter
    @Setter
    @Column(name = "city")
    @NotBlank
    private String city;

    @Getter
    @Setter
    @Column(name = "telephone")
    @NotBlank
    @Digits(fraction = 0, integer = 12)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Child> pets;

    protected Set<Child> getPetsInternal() {
        if (this.pets == null) {
            this.pets = new HashSet<>();
        }
        return this.pets;
    }

    public List<Child> getPets() {
        final List<Child> sortedChildren = new ArrayList<>(getPetsInternal());
        PropertyComparator.sort(sortedChildren, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedChildren);
    }

    public void addPet(Child child) {
        getPetsInternal().add(child);
        child.setOwner(this);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getId())
            .append("lastName", this.getLastName())
            .append("firstName", this.getFirstName())
            .append("address", this.address)
            .append("city", this.city)
            .append("telephone", this.telephone)
            .toString();
    }
}
