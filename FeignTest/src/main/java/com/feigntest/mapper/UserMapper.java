package com.feigntest.mapper;

import com.feigntest.config.FeignConfig;
import com.feigntest.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "user-service",fallback = feignOfRibbonOfUser.class)
@FeignClient(value = "user-service",configuration = FeignConfig.class)
public interface UserMapper {

    @GetMapping("/user/{id}")
    User queryUserByFeignId(@PathVariable("id")Long id);
}
