package com.example.Employees.error;

public class EmployeesNotFoundException extends Exception{
    public EmployeesNotFoundException() {
        super();
    }

    public EmployeesNotFoundException(String message) {
        super(message);
    }

    public EmployeesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeesNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EmployeesNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
