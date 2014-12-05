package com.toyo.vc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lsr on 12/4/14.
 */
@Controller
@RequestMapping("/list")
public class ListController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "list/kouji";
    }

    @RequestMapping(value = "/tenken", method = RequestMethod.GET)
    public String tenken(){
        return "list/tenken";
    }

    @RequestMapping(value = "/kenan", method = RequestMethod.GET)
    public String kenan(){
        return "list/kenan";
    }
}
