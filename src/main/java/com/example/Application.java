package com.example;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.activiti.ActivitiDemo;
import com.example.jpa.repository.Customer;
import com.example.jpa.repository.CustomerRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	public ActivitiDemo  demo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	//@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			if (repository.findAll() != null) {
				return;
			}

			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer", "Jack@builder.com", new Date()));
			repository.save(new Customer("Chloe", "O'Brian", "Chloe@builder.com", new Date()));
			repository.save(new Customer("Kim", "Bauer", "Kim@builder.com", new Date()));
			repository.save(new Customer("David", "Palmer", "David@builder.com", new Date()));
			repository.save(new Customer("Michelle", "Dessler", "Michelle@builder.com", new Date()));
			repository.save(new Customer("Tony", "Qi", "qijunbo@builder.com", new Date()));
			repository.save(new Customer("Jone", "Fathe", "jone@builder.com", new Date()));
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(c -> log.info(c.toString()));
		};
	}

	@Bean
	public CommandLineRunner activitiDemo( ) {
		return (args) -> {
			demo.demo();
		};
	}

}
