package com.petproject.ppmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomerResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler
  public final ResponseEntity<?> handlerProjectIdException(
      ProjectIdException ex, WebRequest request) {
    ProjectIdExceptionResponse exResponse = new ProjectIdExceptionResponse(ex.getMessage());
    return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
  }

}
