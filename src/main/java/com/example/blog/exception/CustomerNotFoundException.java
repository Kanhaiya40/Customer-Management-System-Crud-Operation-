package com.example.blog.exception;

import org.springframework.http.HttpStatus;



public class CustomerNotFoundException extends RuntimeException {
   public  CustomerNotFoundException(String msg)
    {
        super(msg);
    }
}
