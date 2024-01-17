package com.example.foodshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ProiectJavaFoodShop implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProiectJavaFoodShop.class, args);
    }

    public void run(String... args) throws Exception {

    }
}
