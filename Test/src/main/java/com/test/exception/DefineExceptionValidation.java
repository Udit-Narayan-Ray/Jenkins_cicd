package com.test.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefineExceptionValidation {

    @ExceptionHandler({UserDefineException.class})
    String userDefineException(UserDefineException exception){
        return exception.getMessage();
    }

}
