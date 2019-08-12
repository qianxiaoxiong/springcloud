package com.eurakaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@springbootApplication 包含@SpringBooutConfiguaration   @EnabelConfiguration   @ComponetScan
@SpringBootApplication
//启动Euraka服务器
@EnableEurekaServer

public class EurakaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurakaServerApplication.class,args);
    }
}
