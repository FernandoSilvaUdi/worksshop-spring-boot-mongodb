package com.fernandosilva.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernandosilva.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice // avisa que essa classe vai tratar possiveis erros na aplicação
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) // quando ocorrer essa exceção, tratar como está abaixo
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
