package com.toyo.vc.controller;

import com.toyo.vc.entity.User;
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
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "redirect:/";
        } else {
            System.out.println(user.getKengen());
            return "index";
        }
    }
}
