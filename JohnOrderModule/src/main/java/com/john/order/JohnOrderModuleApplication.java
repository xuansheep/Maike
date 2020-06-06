package com.john.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.john.order"})
@EnableScheduling
@ServletComponentScan
@EnableJpaAuditing
public class JohnOrderModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JohnOrderModuleApplication.class, args);
    }

}
