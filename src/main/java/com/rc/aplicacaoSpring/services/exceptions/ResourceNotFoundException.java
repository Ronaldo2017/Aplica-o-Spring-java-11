package com.rc.aplicacaoSpring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		//tenta achar o id do objeto se nao achar mostra a excecao
		super("Resource not found. Id " + id);
	}

}
