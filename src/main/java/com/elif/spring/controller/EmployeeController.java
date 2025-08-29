package com.elif.spring.controller;

import com.elif.spring.dto.request.EmployeeRequest;
import com.elif.spring.dto.response.EmployeeResponse;
import com.elif.spring.entity.Employee;
import com.elif.spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Page<EmployeeResponse> findAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size) {
        return employeeService.findAll(page, size);
    }

    @GetMapping("/get/{id}")
    public EmployeeResponse findById(@PathVariable(name = "id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeResponse save(@RequestBody EmployeeRequest request) {
        return employeeService.save(request);
    }

    @PutMapping("/put/{id}")
    public EmployeeResponse update(@PathVariable(name = "id") Long id, @RequestBody EmployeeRequest request) {
        return employeeService.update(id, request);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
    }


    @GetMapping("/name/{name}")
    public List<EmployeeResponse> findByNameContaining(@PathVariable("name") String name) {
        return employeeService.findByNameContaining(name);
    }

    @GetMapping("/dept/{department}")
    public List<EmployeeResponse> findByDepartment(@PathVariable("department") String department) {
        return employeeService.findByDepartment(department);
    }
//
//    @GetMapping("/salary")
//    public List<Employee> findSalaryGreaterThan(@RequestParam(value = "amount") double amount) {
//        return employeeService.findSalaryGreaterThan(amount);
//    }
//
//
//    @GetMapping("/department")
//    public List<Employee> findDepartmentByQuery(@RequestParam(value = "department") String dept){
//        return employeeService.findDepartmentByQuery(dept);
//    }

}
