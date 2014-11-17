package com.toyo.vc.controller;

import com.google.gson.Gson;
import com.toyo.vc.dto.ValveKikiForm;
import com.toyo.vc.entity.Kiki;
import com.toyo.vc.entity.Kouji;
import com.toyo.vc.entity.User;
import com.toyo.vc.entity.Valve;
import com.toyo.vc.service.ItemService;
import com.toyo.vc.service.KoujiService;
import com.toyo.vc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/testItem")
public class Test2Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private KoujiService koujiService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/getItemByLocationName",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getItemByLocationName(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        String locationName="四国電力徳島発電所１号機";
        List<Valve> valves=itemService.getItemByLocationName(locationName);
        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(valves));
        return "zuitest";
    }

    @RequestMapping(value="/getKikiByKikisysIdSyukan",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getKikiByKikisysIdSyukan(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        String kikiSysId="204";
        String syukan="太陽石";
//        ValveKikiForm valveKikiForm=new ValveKikiForm();
//        valveKikiForm.setKikiSysId(kikiSysId);
//        valveKikiForm.setSyukan(syukan);
        List<Kiki> kiki=itemService.getKikiByKikisysIdSyukan(kikiSysId,syukan);
        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(kiki));
        return "zuitest";
    }

    @RequestMapping(value="/getKikisysByKikisysId",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getKikisysByKikisysId(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        String kikiSysId="204";
        Valve valves=itemService.getKikisysByKikisysId(kikiSysId);
        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(valves));
        return "zuitest";
    }

    @RequestMapping(value="/getKikiByKikiId",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getKikiByKikiId(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        String kikiId="20000007";
        Kiki kiki=itemService.getKikiByKikiId(kikiId);
        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(kiki));
        return "zuitest";
    }

}