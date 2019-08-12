package com.feigntest.controller;

import com.feigntest.mapper.UserMapper;
import com.feigntest.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("feignUser/{id}")
    @HystrixCommand(fallbackMethod = "defaultfallback")
    public User getUserByFeignId(@PathVariable("id")Long id){
    return  userMapper.queryUserByFeignId(id);
    }

    User defaultfallback(Long id){
        User user = new User();
        user.setId(id);
        user.setName("使用feign外部的hystix: 调用user-service出现问题");
      return  user;
    }
}
