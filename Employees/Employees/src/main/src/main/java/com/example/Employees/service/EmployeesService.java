package com.example.Employees.service;

import com.example.Employees.entity.Employees;
import com.example.Employees.error.EmployeesNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeesService {
    Employees addEmployees(Employees employees);

    List<Employees> getAllEmployees();

    Optional<Employees> findById(Integer id);

    Employees deleteEmployee(Integer id) throws EmployeesNotFoundException;

    Employees updateEmployees(Integer id, Employees employees) throws EmployeesNotFoundException;
}
