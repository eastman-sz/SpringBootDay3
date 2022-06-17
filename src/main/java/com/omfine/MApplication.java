package com.omfine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.omfine.mapper")
public class MApplication {

    public static void main(String[] args){
        SpringApplication.run(MApplication.class);
    }

}
