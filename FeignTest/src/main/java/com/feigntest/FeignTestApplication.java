package com.feigntest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
/*包含SpringBootApplication，CircurtBreaker，EurakaDiscoveryClient*/
   /* SpringBootApplication 包含SpringBootConfiguration EnableConfiguration ComponetScan*/
@EnableFeignClients
public class FeignTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignTestApplication.class,args);
    }
}
