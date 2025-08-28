package com.elif.spring.repository;

import com.elif.spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByNameContaining(String name);
    List<Employee> findByDepartment(String department);

    @Query("SELECT e FROM Employee e WHERE e.salary > :amount")
    List<Employee> findSalary(@Param("amount") double amount);

    @Query(value = "SELECT * FROM employee WHERE department = :dept", nativeQuery = true)
    List<Employee> findDepartmentByQuery(@Param("dept")  String dept);
}
