package com.rc.aplicacaoSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rc.aplicacaoSpring.entities.Order;
import com.rc.aplicacaoSpring.entities.User;
import com.rc.aplicacaoSpring.entities.enums.OrderStatus;
import com.rc.aplicacaoSpring.repositories.OrderRepository;
import com.rc.aplicacaoSpring.repositories.UserRepository;

@Configuration
@Profile("test") // vem do arquivo = aplication-test-properties
public class TestConfig implements CommandLineRunner {
	// injeção de dependencia = com o userrepository
	
	@Autowired // resolve a injeção de dependencia
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * este metodo vai ser rodado, todas as vezes que a aplicação for iniciada
		 */

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		//associacao user > order
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1); 
		
		// salvando os dados no bd/ passando uma lista de usuarios / Arrays.asList(u1,
		// u2)
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
