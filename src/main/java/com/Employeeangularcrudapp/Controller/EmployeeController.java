package com.Employeeangularcrudapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employeeangularcrudapp.Model.Employee;
import com.Employeeangularcrudapp.Repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//Get All Employees
	@GetMapping("/employees")
	public List<Employee> displayMessage() {
		return (List<Employee>) employeeRepository.findAll();
	}
	
	//Add employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp){
		return employeeRepository.save(emp);
	}
	
	//Get single Employee by ID
		//@SuppressWarnings("deprecation")
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			Optional<Employee> e=employeeRepository.findById(id);
			//e.get();
			return ResponseEntity.ok().body(e.get());
		}
		
	//Delete employee by using id
		@DeleteMapping("/employees/{id}")
		public String deleteEmployeeById(@PathVariable Long id) {
			employeeRepository.deleteById(id);
			return "Record has been deleted successfully";
		}
		
		//Update a employee by ID
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id ,  @RequestBody Employee employee) {
			Employee getEmp = employeeRepository.findById(id).get();
			getEmp.setFirstName(getEmp.getFirstName());
			getEmp.setLastName(getEmp.getLastName());
			getEmp.setEmail(getEmp.getEmail());
			
			Employee e = employeeRepository.save(getEmp);
			
			return ResponseEntity.ok().body(e);
			
		}
		
		
		

}
