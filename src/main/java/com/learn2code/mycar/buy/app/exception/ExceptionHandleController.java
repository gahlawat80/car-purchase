package com.learn2code.mycar.buy.app.exception;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandleController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DetailsNotFoundException.class)
    public ResponseEntity<ErrorDetail> notFoundException(DetailsNotFoundException ex){
        ErrorDetail details = new ErrorDetail();
        details.setStatus(HttpStatus.NOT_FOUND);
        details.setMessage(ex.getMessage());
        return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
    }
}
