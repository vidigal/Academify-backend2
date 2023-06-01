package com.academify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AcademifyBackend2Application {

    public static void main(String[] args) {
        SpringApplication.run(AcademifyBackend2Application.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
