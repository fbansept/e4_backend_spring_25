package edu.fbansept.e4_backend_spring_25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing//important pour @CreatedDate
public class E4BackendSpring25Application {

    public static void main(String[] args) {
        int toto = 42;
        SpringApplication.run(E4BackendSpring25Application.class, args);
    }

}
