package net.javaguides.springboot.controller;

import net.javaguides.springboot.Service.EmployeeService;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.listAll();
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {
        Employee employee=employeeService.get(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody @NotNull Employee employeeDetails)
    {
        Employee updateEmployee=employeeService.get(id);
        updateEmployee.setFname(employeeDetails.getFname());
        updateEmployee.setLname(employeeDetails.getLname());
        updateEmployee.setEmail(employeeDetails.getEmail());
        employeeService.save((updateEmployee));
        return ResponseEntity.ok(updateEmployee);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id)
    {

        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
