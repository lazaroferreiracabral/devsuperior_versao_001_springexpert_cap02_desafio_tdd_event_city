package com.devsuperior.demo.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.demo.dto.CustomErrorDTO;
import com.devsuperior.demo.exception.DatabaseException;
import com.devsuperior.demo.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorDTO> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomErrorDTO customErrorDTO = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(customErrorDTO);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<CustomErrorDTO> database (DatabaseException e, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		CustomErrorDTO customErrorDTO = new CustomErrorDTO(Instant.now(), httpStatus.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(customErrorDTO);
	}

}
