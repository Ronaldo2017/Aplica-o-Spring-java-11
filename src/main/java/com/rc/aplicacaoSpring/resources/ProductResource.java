package com.rc.aplicacaoSpring.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.aplicacaoSpring.entities.Product;
import com.rc.aplicacaoSpring.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
//	ProductResource depende da ProductService
	
	@Autowired
	private ProductService service;
	
	//end point para acesso aos usuarios
	//responde a requisição do tipo get do http
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		//Product u = new Product(1L, "Pedro", "pedro@email.com", "74598437", "2458");
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);//retorna o usuario
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
