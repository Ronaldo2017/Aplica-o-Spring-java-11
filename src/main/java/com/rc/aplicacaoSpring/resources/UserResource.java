package com.rc.aplicacaoSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.aplicacaoSpring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//end point para acesso aos usuarios
	//responde a requisição do tipo get do http
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Pedro", "pedro@email.com", "74598437", "2458");
		return ResponseEntity.ok().body(u);//retorna o usuario
	}

}
