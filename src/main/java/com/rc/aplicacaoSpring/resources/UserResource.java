package com.rc.aplicacaoSpring.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.aplicacaoSpring.entities.User;
import com.rc.aplicacaoSpring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
//	UserResource depende da UserService
	
	@Autowired
	private UserService service;
	
	//end point para acesso aos usuarios
	//responde a requisição do tipo get do http
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		//User u = new User(1L, "Pedro", "pedro@email.com", "74598437", "2458");
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);//retorna o usuario
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
