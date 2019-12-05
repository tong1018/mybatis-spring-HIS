package com.ct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@MapperScan("com.ct.mapper")
@SpringBootApplication
public class MybatisSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringApplication.class, args);
    }


}
