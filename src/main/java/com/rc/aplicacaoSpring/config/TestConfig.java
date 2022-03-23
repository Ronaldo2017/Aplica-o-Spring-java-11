package com.rc.aplicacaoSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rc.aplicacaoSpring.entities.User;
import com.rc.aplicacaoSpring.repositories.UserRepository;

@Configuration
@Profile("test") // vem do arquivo = aplication-test-properties
public class TestConfig implements CommandLineRunner {
	// injeção de dependencia = com o userrepository
	@Autowired // resolve a injeção de dependencia
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * este metodo vai ser rodado, todas as vezes que a aplicação for iniciada
		 */

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// salvando os dados no bd/ passando uma lista de usuarios / Arrays.asList(u1,
		// u2)
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
