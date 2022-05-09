package com.example.Employees.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeID;

    private String firstName;
    private String lastName;

    @Email
    private String email;

//    @Size(min = 9, max = 11, message = "Please enter a 10 digit phone number.")
    private Long phoneNumber;

    private String department;

//    @DateTimeFormat(pattern = "mm-DD-yyyy")
    private Date hireDate;

    private Integer salary;
}
