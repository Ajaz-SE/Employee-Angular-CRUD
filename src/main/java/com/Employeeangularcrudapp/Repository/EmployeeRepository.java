package com.Employeeangularcrudapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Employeeangularcrudapp.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
