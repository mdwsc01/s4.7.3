package com.example.session07.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error ->{
                    errors.putIfAbsent(
                            error.getField(),
                            error.getDefaultMessage()
                    );
                });

        Map<String,Object> response = new LinkedHashMap<>();
        response.put("message","Dữ liệu không hợp lệ");
        response.put("data",errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
