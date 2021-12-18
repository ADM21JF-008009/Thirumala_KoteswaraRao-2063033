package com.cognizant.Hibernate.Relationships.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.Hibernate.Relationships.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

//	@Query(value = "SELECT e FROM Employee e WHERE e.permanent = 1")
//	@Query(value="SELECT e FROM Employee e left join e.department d left join e.skillList WHERE e.permanent = 1")
	@Query(value = "SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();

	/*
	 * NOTE: HQL looks like SQL, instead of table, Java classes and it's instance
	 * variables are addressed here
	 * 
	 * Join keyword links the table, but does not populate the beans. Fetch ensures
	 * that the beans are populated. Based on our need wherever we need data, we can
	 * define fetch. When joining table data is not needed the fetch can be ignored.
	 * 
	 */

	@Query(value = "SELECT AVG(e.salary) FROM Employee e")
	double getAverageSalary();

	@Query(value = "SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
	double getAverageSalaryFilteredByDepartment(@Param("id") int id);

	@Query(value = "SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();

}