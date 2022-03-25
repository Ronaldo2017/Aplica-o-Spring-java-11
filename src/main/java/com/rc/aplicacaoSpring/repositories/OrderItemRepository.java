package com.rc.aplicacaoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rc.aplicacaoSpring.entities.OrderItem;

//JpaRepository<1 - User, 2- Long> = 1 = tipo da entidade, 2 = tipo do id
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
