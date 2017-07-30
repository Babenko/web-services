package com.foxic.genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenreServicesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GenreServicesApplication.class, args);
	}



	@Override
	public void run(String... strings) throws Exception {
		System.out.println("fdsf");
	}
}
