package com.cognizant.Hibernate.Relationships.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "dp_id")
	private int id;

	@Column(name = "dp_name")
	private String name;

	@OneToMany(mappedBy = "department",fetch = FetchType.EAGER)
	private Set<Employee> employeeList;

	public Department() {
	}

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department(int id, String name, Set<Employee> employeeList) {
		super();
		this.id = id;
		this.name = name;
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
