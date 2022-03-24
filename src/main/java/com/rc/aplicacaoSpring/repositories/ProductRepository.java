package com.rc.aplicacaoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rc.aplicacaoSpring.entities.Product;

//JpaRepository<1 - User, 2- Long> = 1 = tipo da entidade, 2 = tipo do id
public interface ProductRepository extends JpaRepository<Product, Long> {

}
