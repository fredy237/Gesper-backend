package com.example.demoplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demoplanning.utils")
public class DemoPlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoPlanningApplication.class, args);
    }

}
