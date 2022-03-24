package com.spring.springweek01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringWeek01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeek01Application.class, args);
    }

}
