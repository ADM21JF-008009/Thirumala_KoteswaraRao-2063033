package com.cognizant.Hibernate.Relationships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Hibernate.Relationships.model.Department;
import com.cognizant.Hibernate.Relationships.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Transactional
    public Department get(int id) {
        return departmentRepository.findById(id).get();
    }

}
