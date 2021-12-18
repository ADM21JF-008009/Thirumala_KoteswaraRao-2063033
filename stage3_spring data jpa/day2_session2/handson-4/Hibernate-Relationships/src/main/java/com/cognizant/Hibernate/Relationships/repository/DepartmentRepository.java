package com.cognizant.Hibernate.Relationships.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.Hibernate.Relationships.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
