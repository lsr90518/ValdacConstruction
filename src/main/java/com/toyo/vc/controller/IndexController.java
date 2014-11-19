package com.toyo.vc.controller;

import com.toyo.vc.entity.Kouji;
import com.toyo.vc.entity.User;
import com.toyo.vc.service.KoujiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Lsr on 11/14/14.
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    KoujiService koujiService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpSession session, ModelMap modelMap){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "login";
        } else {
            if(user.getKengen().equals("6")){
                modelMap.addAttribute("lastedKoujiList",koujiService.getLastedTenKoujiByPerson("zui"));
                modelMap.addAttribute("updatedKoujiList",koujiService.getUpdateTenKoujiByPerson("zui"));
            } else {
                modelMap.addAttribute("lastedKoujiList",koujiService.getLastedTenKoujiByPerson(user.getUserid()));
                modelMap.addAttribute("updatedKoujiList",koujiService.getUpdateTenKoujiByPerson(user.getUserid()));
            }
            return "index";
        }
    }
}
