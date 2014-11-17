package com.toyo.vc.controller;

import com.toyo.vc.entity.User;
import com.toyo.vc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Lsr on 11/14/14.
 */

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String login(HttpSession session){
        User user = (User) session.getAttribute("user");
        session.setAttribute("imageRoot","http://storage.googleapis.com/valdac/");
        if(user != null){
            return "redirect:/index";
        } else {
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginByUserid(@RequestParam("userid")String userid,
                                @RequestParam("password")String password,
                                HttpSession session){
        User user = userService.getUserByUseridAndPassword(userid,password);
        session.setAttribute("imageRoot","http://storage.googleapis.com/valdac/");
        if(user == null){
            return "login";
        } else {
            session.setAttribute("user",user);
            return "redirect:/index";
        }
    }
}
