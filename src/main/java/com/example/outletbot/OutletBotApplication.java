package com.example.outletbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableScheduling
@SpringBootApplication()
@EnableWebMvc
public class OutletBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutletBotApplication.class, args);
    }

}
