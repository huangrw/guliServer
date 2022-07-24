package com.tnt.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月17日 15:05:00
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.tnt"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
