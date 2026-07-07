package org.example.a07_sparks_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class A07SparksSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(A07SparksSpringbootApplication.class, args);
    }

}
