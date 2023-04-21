package com.inventiveit;

import com.inventiveit.entity.DreamCase;
import com.inventiveit.repository.DreamCaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class InventiveitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventiveitTestApplication.class, args);
	}


	@Bean
	public CommandLineRunner start(DreamCaseRepository dreamCaseRepository) {
		return args -> {
			System.out.println("************");
			for (int i = 0; i < 3; i++) {
				DreamCase dreamCase=new DreamCase(null, LocalDateTime.now(),LocalDateTime.now(),"Title "+i,"Description "+i);
				System.out.println(dreamCaseRepository.save(dreamCase));
			}
			System.out.println("************");
		};
	}

}
