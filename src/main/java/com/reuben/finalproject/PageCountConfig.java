package com.reuben.finalproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageCountConfig {
    @Bean
    public PageCounter getPageCount(){
        return new PageCounter();
    }
}
