package com.maike.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@MapperScan(basePackages={"com.maike.order.dao"})
public class MaikeOrderModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaikeOrderModuleApplication.class, args);
    }

}
