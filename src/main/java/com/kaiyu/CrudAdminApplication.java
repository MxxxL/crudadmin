package com.kaiyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.kaiyu.dao")
public class CrudAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudAdminApplication.class, args);
    }

}
