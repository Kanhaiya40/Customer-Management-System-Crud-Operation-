package com.example.blog.api;

import com.example.blog.exception.ApplicationError;
import com.example.blog.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandlerService extends ResponseEntityExceptionHandler {
    @Value("${api_doc_url}")
    private String details;
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> responseEntity(CustomerNotFoundException customerException, WebRequest web)
    {
        ApplicationError error=new ApplicationError();
        error.setCode(102);
        error.setMsg(customerException.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
