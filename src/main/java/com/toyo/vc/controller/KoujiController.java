package com.toyo.vc.controller;

import com.toyo.vc.dto.KoujiForm;
import com.toyo.vc.entity.Kouji;
import com.toyo.vc.entity.Valve;
import com.toyo.vc.service.ItemService;
import com.toyo.vc.service.KoujiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Lsr on 11/14/14.
 */

@Controller
@RequestMapping("/kouji")
public class KoujiController {

    @Autowired
    KoujiService koujiService;
    @Autowired
    ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpSession session){

        return "/kouji/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addKouji(HttpSession session){
        return "/kouji/addKouji";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addKoujiByForm(@ModelAttribute("KoujiForm")KoujiForm koujiForm,HttpSession session, ModelMap modelMap){
        koujiForm.setStatus("0");
        Kouji kouji = koujiService.addKouji(koujiForm);
        List<Valve> valveList = itemService.getItemByLocationName(kouji.getLocation());
        modelMap.addAttribute("kouji",kouji);
        modelMap.addAttribute("valveList",valveList);
        return "/kouji/addValve";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getKoujiById(@PathVariable("id")String id, ModelMap modelMap, HttpSession session){
        Kouji kouji = new Kouji();
        modelMap.addAttribute("kouji",kouji);
        return "/kouji/index";
    }

    @RequestMapping(value = "/{id}/history", method = RequestMethod.GET)
    public String getHistoryById(@PathVariable("id")String id, ModelMap modelMap, HttpSession session){
        Kouji kouji = new Kouji();
        modelMap.addAttribute("kouji",kouji);
        return "/kouji/history";
    }
}
