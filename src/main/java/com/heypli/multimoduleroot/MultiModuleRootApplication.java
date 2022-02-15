package com.heypli.multimoduleroot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.heypli"})
@EnableJpaRepositories({"com.heypli.repo.repository"})
@EntityScan({"com.heypli.repo.domain"})
public class MultiModuleRootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleRootApplication.class, args);
    }

}
