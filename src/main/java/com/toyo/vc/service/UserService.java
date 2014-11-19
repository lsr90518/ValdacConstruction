package com.toyo.vc.service;

import com.toyo.vc.dao.UserMapper;
import com.toyo.vc.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public User getUserByUseridAndPassword(String userid,String password){
        User userTem=new User();
        userTem.setUserid(userid);
        userTem.setPassword(password);

        User user = userMapper.findByUserId(userTem);

        if(user!=null){
            return user;
        } else {
            return null;
        }
    }

    public List<String> getUserByKengen(String kengen){
        List<String> username=userMapper.findUserByKengen(kengen);
        return  username;
    }
}
