package com.product;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootGrpcServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGrpcServerApplication.class, args);
    }

}
