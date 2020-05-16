package com.john.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@MapperScan(basePackages={"com.john.order"})
public class JohnOrderModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JohnOrderModuleApplication.class, args);
    }

}
