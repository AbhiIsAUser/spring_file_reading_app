package com.newera;

import com.newera.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewerabeginsApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(NewerabeginsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookService.processBook(); // Call the processBook method here
	}
}
