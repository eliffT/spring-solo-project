package com.elif.spring.controller;

import com.elif.spring.entity.Employee;
import com.elif.spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/get/{id}")
    public Employee findById(@PathVariable(name = "id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/put/{id}")
    public Employee update(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
    }


    @GetMapping("/name/{name}")
    public List<Employee> findByNameContaining(@PathVariable("name") String name) {
        return employeeService.findByNameContaining(name);
    }

    @GetMapping("/dept/{department}")
    public List<Employee> findByDepartment(@PathVariable("department") String department) {
        return employeeService.findByDepartment(department);
    }



}
