package com.rc.aplicacaoSpring.resources.exeptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rc.aplicacaoSpring.services.exceptions.ResourceNotFoundException;


//intersepta as excessoes, para o objeto tratar 
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
			HttpServletRequest request){
		/*
		 * esse metodo resourceNotFound, vai interseptar essa
		 *  qualquer excecao  desse tipo resourceNotFound que 
		 * for lançada
		 */
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), 
				status.value(), error, e.getMessage()
				, request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
