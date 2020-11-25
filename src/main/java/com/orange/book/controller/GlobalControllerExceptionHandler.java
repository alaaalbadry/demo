package com.orange.book.controller;

import com.orange.book.model.payload.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@ControllerAdvice
class GlobalControllerExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponse> handleAnyException(NoSuchElementException ex, WebRequest request) {
        return ResponseEntity.status(404).body(new ExceptionResponse("Element Not Found"));
    }
}