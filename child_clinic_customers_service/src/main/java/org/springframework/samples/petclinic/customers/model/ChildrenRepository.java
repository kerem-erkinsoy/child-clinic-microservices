
package org.springframework.samples.petclinic.customers.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChildrenRepository extends JpaRepository<Child, Integer> {

    @Query("SELECT ptype FROM DiseaseType ptype ORDER BY ptype.name")
    List<DiseaseType> findPetTypes();

    @Query("FROM DiseaseType ptype WHERE ptype.id = :typeId")
    Optional<DiseaseType> findPetTypeById(@Param("typeId") int typeId);


}

