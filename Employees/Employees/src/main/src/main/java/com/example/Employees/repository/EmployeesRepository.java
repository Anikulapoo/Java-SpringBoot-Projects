package com.example.Employees.repository;

import com.example.Employees.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

}
