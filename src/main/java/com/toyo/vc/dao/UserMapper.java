package com.toyo.vc.dao;

import com.toyo.vc.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhangrui on 14/11/14.
 */
public interface UserMapper {
//    @Select("select * from user where userId=#{userId}")
    public User findByUserId(String userid);
}
