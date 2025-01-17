package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // add an exceptopn handler for customer not found excption

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException (CustomerNotFoundException exc)
    {
        // create CustomerError Response
        CustomerErrorResponse error=new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
        //return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
    //catch any exception


    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException (Exception exc)
    {
        // create CustomerError Response
        CustomerErrorResponse error=new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
        //return response entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
