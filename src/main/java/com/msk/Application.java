package com.msk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.msk.mapper")
public class Application {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        SpringApplication.run(Application.class, args);
    }

}
