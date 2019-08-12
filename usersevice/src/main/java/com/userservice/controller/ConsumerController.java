package com.userservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.userservice.mappers.UserMapper;
import com.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

@DefaultProperties(defaultFallback = "defaultFallBack")
public class ConsumerController {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RestTemplate template;

    @GetMapping("restTempletaUser/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "queryUserById")
    public ResponseEntity<User> getRestTemplateUser(@PathVariable("id") Long id) {

     if(id==1L){
         System.out.println("到此一游");
        throw new ArithmeticException();
     }
        String url = "http://user-service/user/" + id;
        User forObject = template.getForObject(url, User.class);
        return ResponseEntity.ok(forObject);
    }

        @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Long id){
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println(user);
        return  user;
    }

//    @GetMapping("id")
    public ResponseEntity<User> defaultFallBack() {
         throw   new RuntimeException("default:sorry,network too crowed!");
    }
    //报错的日志ERROR 19328 --- [merController-1] c.n.h.c.javanica.command.GenericCommand  : failed to process fallback is the method: 'defaultFallBack'.
}
