package com.rc.aplicacaoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rc.aplicacaoSpring.entities.Order;

//JpaRepository<1 - Order, 2- Long> = 1 = tipo da entidade, 2 = tipo do id
public interface OrderRepository extends JpaRepository<Order, Long> {

}
