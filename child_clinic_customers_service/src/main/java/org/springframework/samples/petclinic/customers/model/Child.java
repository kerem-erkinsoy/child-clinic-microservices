
package org.springframework.samples.petclinic.customers.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.core.style.ToStringCreator;


@Data
@Entity
@Table(name = "pets")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private DiseaseType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Parent owner;


    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", this.getId())
            .append("name", this.getName())
            .append("birthDate", this.getBirthDate())
            .append("type", this.getType().getName())
            .append("ownerFirstname", this.getOwner().getFirstName())
            .append("ownerLastname", this.getOwner().getLastName())
            .append("gender", this.getGender())
            .toString();
    }

}
