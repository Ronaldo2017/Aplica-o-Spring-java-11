package com.rc.aplicacaoSpring.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.aplicacaoSpring.entities.Category;
import com.rc.aplicacaoSpring.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
//	CategoryResource depende da CategoryService
	
	@Autowired
	private CategoryService service;
	
	//end point para acesso aos usuarios
	//responde a requisição do tipo get do http
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		//Category u = new Category(1L, "Pedro", "pedro@email.com", "74598437", "2458");
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);//retorna o usuario
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
