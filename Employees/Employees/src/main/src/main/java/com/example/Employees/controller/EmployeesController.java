package com.example.Employees.controller;

import com.example.Employees.entity.Employees;
import com.example.Employees.error.EmployeesNotFoundException;
import com.example.Employees.service.EmailSenderService;
import com.example.Employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/hr")
public class EmployeesController {

    public final Logger LOGGER = Logger.getLogger(String.valueOf(EmployeesController.class));

    @Autowired
    private EmployeesService employeesService;
    @Autowired
    EmailSenderService senderService;

    @PostMapping("/add")
    public Employees addEmployees (@Valid @RequestBody Employees employees){
        LOGGER.info("Inside of addEmployees of Employees Controller");
        senderService.sendEmail("yosephfl@gmail.com","Test Mail", "It was a success!");
        return employeesService.addEmployees(employees);
    }

    @GetMapping("/all")
    public List<Employees> getAllEmployees(){
        LOGGER.info("Inside of getAllEmployees of Employees Controller");
        return employeesService.getAllEmployees();
    }

    @GetMapping("/find/{id}")
    public Optional<Employees> findById(@PathVariable("id") Integer id) throws EmployeesNotFoundException {
        LOGGER.info("Inside of findById of Employees Controller");
        return employeesService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public Employees deleteEmployee(@PathVariable("id") Integer id)throws EmployeesNotFoundException{
        LOGGER.info("Inside of deleteEmployee of Employees Controller");
        return employeesService.deleteEmployee(id);
    }

    @PutMapping("update/{id}")
    public Employees updateEmployees(@PathVariable("id") Integer id, Employees employees) throws EmployeesNotFoundException{
        LOGGER.info("Inside of updateEmployee of Employees Controller");
        return employeesService.updateEmployees(id,employees);
    }

}
