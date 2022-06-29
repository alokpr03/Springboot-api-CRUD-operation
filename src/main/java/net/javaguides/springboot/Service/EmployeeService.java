package net.javaguides.springboot.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    public List<Employee> listAll(){
        return repo.findAll();
    }
    public Employee save(Employee employee){
        return repo.save(employee);
    }
    public Employee get(long id){
        return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found :"+id));
    }
    public  void delete(long id){
        repo.deleteById(id);
    }
}
