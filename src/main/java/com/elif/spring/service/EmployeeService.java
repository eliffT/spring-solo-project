package com.elif.spring.service;

import com.elif.spring.entity.Employee;
import com.elif.spring.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void delete(Long id) {
        Optional<Employee> delEmployee = employeeRepository.findById(id);
        if (delEmployee.isPresent()) {
            employeeRepository.delete(delEmployee.get());
        }
    }

    public Employee update(Long id, Employee employee) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if (optEmployee.isPresent()) {
            Employee uptEmployee = optEmployee.get();
            uptEmployee.setName(employee.getName());
            uptEmployee.setSalary(employee.getSalary());
            uptEmployee.setEmail(employee.getEmail());
            uptEmployee.setDepartment(employee.getDepartment());
            return employeeRepository.save(uptEmployee);
        }
        return null;
    }
}
