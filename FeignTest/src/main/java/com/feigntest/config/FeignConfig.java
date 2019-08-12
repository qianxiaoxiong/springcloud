package com.feigntest.config;


import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level  getLoggerLever(){
        return  Logger.Level.FULL;
    }
}
