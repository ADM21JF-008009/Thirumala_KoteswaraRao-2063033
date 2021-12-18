package com.cognizant.Hibernate.Relationships;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.Hibernate.Relationships.model.Department;
import com.cognizant.Hibernate.Relationships.model.Employee;
import com.cognizant.Hibernate.Relationships.model.Skill;

import com.cognizant.Hibernate.Relationships.service.DepartmentService;
import com.cognizant.Hibernate.Relationships.service.EmployeeService;
import com.cognizant.Hibernate.Relationships.service.SkillService;

@SpringBootApplication
public class HibernateRelationshipsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateRelationshipsApplication.class);

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HibernateRelationshipsApplication.class, args);

		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

//		testGetEmployee();

//		testAddEmployee();

//		testUpdateEmployee();

//		testGetDepartment();

//		testGetEmployeeForManyToMany();

//		testAddSkillToEmployee();

//		testGetAllPermanentEmployees();
		
		testAvgSalaryOfEmployees();
		
		testAvgSalaryOfEmployeesFilteredByDepartment();
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {

		Employee e1 = new Employee();
		e1.setId(10);
		e1.setName("Abc");
		e1.setSalary(500000);
		e1.setPermanent(true);
		e1.setDateOfBirth(Date.valueOf("1997-01-01"));
		e1.setDepartment(departmentService.get(1));

		employeeService.save(e1);

		LOGGER.info("Start");
		Employee employee = employeeService.get(10);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {

		Employee e2 = employeeService.get(10);
		Department d2 = departmentService.get(2);

		e2.setDepartment(d2);

		employeeService.save(e2);

		LOGGER.info("Start");
		Employee employee = employeeService.get(10);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Update successfull");
		LOGGER.info("End");
	}

	private static void testGetDepartment() {
		Department d3 = departmentService.get(3);
		Set<Employee> employeeSet = d3.getEmployeeList();

		LOGGER.info("Start");
		LOGGER.debug("Employee:{}", employeeSet);
		LOGGER.debug("Department:{}", d3);
		LOGGER.info("End");
	}

	private static void testGetEmployeeForManyToMany() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		Employee e = employeeService.get(1);
		Skill s = skillService.get(3);

		Set<Skill> skillSet = e.getSkillList();
		skillSet.add(s);

		employeeService.save(e);

		LOGGER.info("Start");
//		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", e);
		LOGGER.debug("Skills:{}", e.getSkillList());
		LOGGER.info("End");
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.listOfAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	public static void testAvgSalaryOfEmployees() {
		LOGGER.info("Start");
		double avgSalaryEmp = employeeService.avgSalaryOfEmployees();
		LOGGER.debug("Average Salary of Employees : {}", avgSalaryEmp);
		LOGGER.info("End");
	}
	
	public static void testAvgSalaryOfEmployeesFilteredByDepartment() {
		LOGGER.info("Start");
		double avgSalaryEmpDept = employeeService.avgSalaryOfEmployeesFilteredByDepartment();
		LOGGER.debug("Average Salary of Employees : {}", avgSalaryEmpDept);
		LOGGER.info("End");
	}

}
