package com.toyo.vc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Lsr on 11/14/14.
 */

@Controller
@RequestMapping("/kouji")
public class KoujiController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpSession session){

        return "index";
    }
}
