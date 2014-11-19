package com.toyo.vc.controller;

import com.google.gson.Gson;
import com.toyo.vc.entity.Master;
import com.toyo.vc.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Lsr on 11/19/14.
 */

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    MasterService masterService;

    @RequestMapping(value="/getMasterByTypeJson",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getMasterJson(@RequestParam("type") String type) {

        List<Master> masterList = masterService.getMasterByType(type);
        Gson gson = new Gson();
        return gson.toJson(masterList);
    }
}