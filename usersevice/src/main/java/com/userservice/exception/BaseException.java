package com.userservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.annotation.HandlesTypes;

@ControllerAdvice
public class BaseException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> dealWithException(){
        return ResponseEntity.ok(" 对不起，网络太拥挤了！");
    }
}
