package com.feigntest.exception;

import com.feigntest.mapper.UserMapper;
import com.feigntest.pojo.User;
import org.springframework.stereotype.Component;

//开启feign自带的hystrix
@Component
public class feignOfRibbonOfUser implements UserMapper{

//    使用feign内部的hystrix,注意要开启内部hystrix
    @Override
    public User queryUserByFeignId(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户查询出现异常！");
        return user;
    }
}
