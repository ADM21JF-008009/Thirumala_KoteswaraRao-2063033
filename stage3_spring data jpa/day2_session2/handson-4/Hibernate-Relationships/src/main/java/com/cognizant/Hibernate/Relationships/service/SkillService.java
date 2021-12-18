package com.cognizant.Hibernate.Relationships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Hibernate.Relationships.model.Department;
import com.cognizant.Hibernate.Relationships.model.Skill;
import com.cognizant.Hibernate.Relationships.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;
	
	public Skill get(int id) {
        return skillRepository.findById(id).get();
    }
}
