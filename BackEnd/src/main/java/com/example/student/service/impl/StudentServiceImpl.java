package com.example.student.service.impl;

import com.example.student.deo.EmployeeRepository;
import com.example.student.exception.ResourceNotFoundException;
import com.example.student.model.Employee;
import com.example.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private  final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
       return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

    }

    @Override
    public Employee addEmployee(Employee employee) {
    return   employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee( Employee employee) {
        return  employeeRepository.save(employee);
    }

    @Override
    public  void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);


    }
}
