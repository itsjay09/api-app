package com.farmer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  protected ResponseEntity<ExceptionResponse> handleUserNotFoundException(
      UserNotFoundException ex) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.toString(),
        HttpStatus.NOT_FOUND.value());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ItemNotFoundException.class)
  protected ResponseEntity<ExceptionResponse> handleItemNotFoundException(
      ItemNotFoundException ex) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.toString(),
        HttpStatus.NOT_FOUND.value());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
}
