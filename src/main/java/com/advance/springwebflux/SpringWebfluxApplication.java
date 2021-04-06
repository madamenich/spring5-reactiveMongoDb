package com.advance.springwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Mono;

@SpringBootApplication(scanBasePackages = "com.advance.springwebflux.*")
@ComponentScan("com.advance.springwebflux.*")
public class SpringWebfluxApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringWebfluxApplication.class, args);
    }

}
