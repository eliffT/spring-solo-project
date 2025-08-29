package com.elif.spring.service;

import com.elif.spring.dto.request.EmployeeRequest;
import com.elif.spring.dto.response.EmployeeResponse;
import com.elif.spring.entity.Employee;
import com.elif.spring.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeResponse save(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setId(request.getId());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());
        employee.setEmail(request.getEmail());
        employeeRepository.save(employee);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setName(employee.getName());
        employeeResponse.setDepartment(employee.getDepartment());
        return employeeResponse;
    }

    public EmployeeResponse findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setName(employee.getName());
        employeeResponse.setDepartment(employee.getDepartment());
        return employeeResponse;
    }

    public Page<EmployeeResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
//        List<Employee> employees = employeeRepository.findAll();
//        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
//        for (Employee employee : employees) {
//            EmployeeResponse employeeResponse = new EmployeeResponse();
//            employeeResponse.setName(employee.getName());
//            employeeResponse.setDepartment(employee.getDepartment());
//            employeeResponseList.add(employeeResponse);
//        }
//        return employeeResponseList;
        return employeeRepository.findAll(pageable)
                .map(employee -> {
                    EmployeeResponse response = new EmployeeResponse();
                    response.setName(employee.getName());
                    response.setDepartment(employee.getDepartment());
                    return response;
                });
    }

    public void delete(Long id) {
        Optional<Employee> delEmployee = employeeRepository.findById(id);
        if (delEmployee.isPresent()) {
            employeeRepository.delete(delEmployee.get());
        }
    }

    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if (optEmployee.isPresent()) {
            Employee uptEmployee = optEmployee.get();
            uptEmployee.setName(request.getName());
            uptEmployee.setSalary(request.getSalary());
            uptEmployee.setEmail(request.getEmail());
            uptEmployee.setDepartment(request.getDepartment());
            employeeRepository.save(uptEmployee);
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setName(uptEmployee.getName());
            employeeResponse.setDepartment(uptEmployee.getDepartment());
            return employeeResponse;
        }
        return null;
    }

    public List<EmployeeResponse> findByNameContaining(String name) {
        List<Employee> employee = employeeRepository.findByNameContaining(name);
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        for (Employee emp : employee) {
          EmployeeResponse employeeResponse =  new EmployeeResponse();
          employeeResponse.setName(emp.getName());
          employeeResponse.setDepartment(emp.getDepartment());
          employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }


    public List<EmployeeResponse> findByDepartment(String department) {
        List<Employee> employee = employeeRepository.findByDepartment(department);
        List<EmployeeResponse> responseList = new ArrayList<>();
        for (Employee emp : employee) {
            EmployeeResponse employeeResponse =  new EmployeeResponse();
            employeeResponse.setName(emp.getName());
            employeeResponse.setDepartment(emp.getDepartment());
            responseList.add(employeeResponse);
        }
        return responseList;

    }

//    public List<Employee> findSalaryGreaterThan(double amount) {
//        if(amount < 0) {
//            throw new IllegalArgumentException("Amount must be greater than 0");
//        }
//        return employeeRepository.findSalary(amount);
//    }
//
//    public List<Employee> findDepartmentByQuery(String dept) {
//        if(dept == null) {
//            throw new IllegalArgumentException("Department must not be null");
//        }
//        return employeeRepository.findDepartmentByQuery(dept);
//    }
}
