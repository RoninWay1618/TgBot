package com.qdbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.qdbp.*")
@EntityScan("com.qdbp.*")
@ComponentScan("com.qdbp.*")
@SpringBootApplication
public class RestService {

    public static void main(String[] args) {
        SpringApplication.run(RestService.class);
    }
}

