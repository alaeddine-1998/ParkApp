package com.example.park.Controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	  public void springHandleNotFound(HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.NOT_FOUND.value());
	  }
	
}
