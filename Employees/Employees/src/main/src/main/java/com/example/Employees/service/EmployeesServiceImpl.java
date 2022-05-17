package com.example.Employees.service;

import com.example.Employees.entity.Employees;
import com.example.Employees.error.EmployeesNotFoundException;
import com.example.Employees.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService{
    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Employees addEmployees(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @Override
    public Optional<Employees> findById(Integer id) {
        return employeesRepository.findById(id);
    }

    @Override
    public Employees deleteEmployee(Integer id) throws EmployeesNotFoundException {
        Optional<Employees> deleteEmployeeOptional = employeesRepository.findById(id);
        if (!deleteEmployeeOptional.isPresent()){
            throw new EmployeesNotFoundException();
        }
        Employees deletedEmployee = deleteEmployeeOptional.get();
        employeesRepository.delete(deletedEmployee);
        return deletedEmployee;
    }

    @Override
    public Employees updateEmployees(Integer id, Employees employees) throws EmployeesNotFoundException {
        Optional<Employees> employeesOptional = employeesRepository.findById(id);
        if (!employeesOptional.isPresent()){
            throw new EmployeesNotFoundException();
        }
        Employees employeeToUpdate = employeesOptional.get();
        if (!employees.getDepartment().isEmpty()){
            employeeToUpdate.setDepartment(employees.getDepartment());
        }
        if(employees.getEmail() != null){
            employeeToUpdate.setEmail(employees.getEmail());
        }
        if (employees.getFirstName() != null){
            employeeToUpdate.setFirstName(employees.getFirstName());
        }
        if (employees.getLastName() != null){
            employeeToUpdate.setLastName(employees.getLastName());
        }
        if (employees.getHireDate() != null){
            employeeToUpdate.setHireDate(employees.getHireDate());
        }
        if (employees.getPhoneNumber() != null){
            employeeToUpdate.setPhoneNumber(employees.getPhoneNumber());
        }
        if (employees.getSalary() != null){
            employeeToUpdate.setSalary(employees.getSalary());
        }
        return employeesRepository.save(employeeToUpdate);
    }

}
