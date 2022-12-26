package com.springboot.error;

import com.springboot.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // Currently this controller advice is for all controller but if we want it for specific controller we can
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotfoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotfoundException exception
    , WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage()); // Two parameter are given
        // to constructor
        return ResponseEntity.status(HttpStatus.NOT_FOUND ).body(message);
    }
}
