package com.example.student.service;

import com.example.student.model.Employee;

import java.util.List;

public interface StudentService  {
    List<Employee> getAll();
    Employee getEmployee(Long id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
}
