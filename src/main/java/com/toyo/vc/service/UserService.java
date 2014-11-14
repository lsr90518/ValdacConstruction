package com.toyo.vc.service;

import com.toyo.vc.dao.UserMapper;
import com.toyo.vc.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangrui on 14/11/14.
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;


    public User getUserByUserid(String userid,String password){
        User user = userMapper.findByUserId(userid);

        if(password.equals(user.getPassword())){
            return user;
        } else {
            return null;
        }
    }
}
