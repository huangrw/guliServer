package com.tnt.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月27日 23:06:00
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  //关闭 mysql 数据源的自动配置,防止启动时找不到配置报错
@ComponentScan(basePackages = {"com.tnt"})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}
