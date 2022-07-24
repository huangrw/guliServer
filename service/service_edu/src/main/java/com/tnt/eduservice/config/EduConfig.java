package com.tnt.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月17日 15:07:00
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.tnt.eduservice.mapper")
public class EduConfig  {

    /**
     * @Author huangrw
     * @Description 逻辑删除
     * @Date 19:03 2022/7/17
     * @Param
     * @return
     **/
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     * @Author huangrw
     * @Description 分页插件
     * @Date 02:08 2022/7/18
     * @Param []
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     **/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }


}
