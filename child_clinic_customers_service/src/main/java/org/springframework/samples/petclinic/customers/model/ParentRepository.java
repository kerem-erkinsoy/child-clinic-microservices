package org.springframework.samples.petclinic.customers.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Integer> { }
