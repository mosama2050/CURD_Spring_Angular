package com.example.student.controller;

import com.example.student.model.Employee;
import com.example.student.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/")
public class StudentController {

    private StudentService studentService;
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // http://localhost:8080/api/students
    @GetMapping("students")
    public List<Employee> getStudents(){
        logger.info("get All Students");
        return studentService.getAll();
    }

    // http://localhost:8080/api/students/1
    @GetMapping("students/{id}")
    public ResponseEntity<Employee> getStudentById (@PathVariable("id") Long id){
        logger.info("getStudentById");
        Employee  employee=  studentService.getEmployee(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
    }

    // http://localhost:8080/api/students
    @PostMapping("students")
    public ResponseEntity<Employee> saveStudent(@RequestBody Employee employee){
        logger.info("saveStudent");
        return new ResponseEntity<Employee>( studentService.addEmployee(employee), HttpStatus.OK);
    }

    // http://localhost:8080/api/students/3
    @PutMapping("students/{id}")
    public Employee editStudent(@RequestBody Employee employee,@PathVariable  Long id){
        logger.info("editStudent");
        employee.setId(id);
        return studentService.updateEmployee(employee);
    }

    @DeleteMapping("students")
    public   ResponseEntity removeStudent(@RequestParam Long id){
        logger.info("removeStudent");
        studentService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}