package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class DemoException {
    private static final String EMPLOYEE_NOT_FOUND_MSG_KEY = "EmployeeNotExisted";

    private static final String EMPLOYEE_MSG = "Employee Not Found";

    public static ResponseException notFound(String messageKey, String message){
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message){
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String messageKey, String message){
        return  new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException employeeNotFound() {
        return notFound(EMPLOYEE_NOT_FOUND_MSG_KEY,EMPLOYEE_MSG);
    }
}
