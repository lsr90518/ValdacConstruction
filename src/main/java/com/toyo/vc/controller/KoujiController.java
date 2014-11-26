package com.toyo.vc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.toyo.vc.dto.KoujiForm;
import com.toyo.vc.dto.ValveKikiSelectUtil;
import com.toyo.vc.entity.*;
import com.toyo.vc.service.ItemService;
import com.toyo.vc.service.KoujiService;
import com.toyo.vc.service.KoujirelationService;
import com.toyo.vc.service.TenkenRirekiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    KoujirelationService koujirelationService;
    @Autowired
    TenkenRirekiService tenkenRirekiService;


    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpSession session){

        return "/kouji/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addKouji(HttpSession session){
        return "/kouji/addKouji";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addKoujiByForm(@ModelAttribute("KoujiForm")KoujiForm koujiForm, ModelMap modelMap){
        koujiForm.setStatus("0");
        Kouji kouji = koujiService.addKouji(koujiForm);
        List<Valve> valveList = itemService.getItemByLocationName(kouji.getLocation());
        modelMap.addAttribute("kouji",kouji);
        modelMap.addAttribute("valveList",valveList);
        return "/kouji/addValve";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getKoujiById(@PathVariable("id")String id, ModelMap modelMap){
        Kouji kouji = koujiService.getKoujiById(id);

        modelMap.addAttribute("kouji", kouji);
        return "/kouji/index";
    }

    @RequestMapping(value = "/{id}/history", method = RequestMethod.GET)
    public String getHistoryById(@PathVariable("id")String id, ModelMap modelMap){
        Kouji kouji = new Kouji();
        modelMap.addAttribute("kouji",kouji);
        return "/kouji/history";
    }

    @RequestMapping(value = "/{id}/valve", method = RequestMethod.POST)
    public String addValveList(@PathVariable("id")String id,
                               @RequestParam("idList")String idList,
                               ModelMap modelMap){
        Kouji kouji = koujiService.getKoujiById(id);
        String[] vids = idList.split(",");
        List<Valve> valveList = new ArrayList<Valve>();

        for(int i = 0;i<vids.length;i++){
            Koujirelation koujirelation = new Koujirelation();
            koujirelation.setKoujiid(Integer.valueOf(id));
            koujirelation.setKikisysid(Integer.valueOf(vids[i]));
            koujirelationService.addKoujirelation(koujirelation);
            valveList.add(itemService.getKikisysByKikisysId(vids[i]));
        }
        modelMap.addAttribute("kouji",kouji);
        modelMap.addAttribute("valveList",valveList);
        return "/kouji/addKiki";
    }
    @RequestMapping(value = "/kiki", method = RequestMethod.GET)
    public String kikiTest(ModelMap modelMap){
        Kouji kouji = koujiService.getKoujiById("299");
        List<Valve> valves = itemService.getItemByLocationName("四国電力徳島発電所１号機");
        modelMap.addAttribute("kouji",kouji);
        modelMap.addAttribute("valveList",valves);
        return "/kouji/addKiki";
    }

    @RequestMapping(value = "/{id}/saveValveKikiRelation", method = RequestMethod.GET)
    public String saveValveKikiRelation(@PathVariable("id")String id,
                                        HttpSession session,
                                        ModelMap modelMap){
        //getFromSession
        List<ValveKikiSelectUtil> valveKikiSelectUtilList = (List<ValveKikiSelectUtil>) session.getAttribute(id);
        for (int i = 0; i < valveKikiSelectUtilList.size(); i++) {
            if(valveKikiSelectUtilList.get(i).getStatus().equals("active")) {
                Koujirelation koujirelation = new Koujirelation();
                koujirelation.setKoujiid(Integer.valueOf(id));
                koujirelation.setKikisysid(Integer.valueOf(valveKikiSelectUtilList.get(i).getKikiSysId()));
                koujirelation.setKikiid(valveKikiSelectUtilList.get(i).getKiki().getKikiId());
                koujirelationService.addKoujirelation(koujirelation);
            }
        }
        Kouji kouji = koujiService.getKoujiById(id);
        modelMap.addAttribute("kouji",kouji);
        List<Valve> valveList = koujirelationService.getKikisysListByKoujiid(id);
        modelMap.addAttribute("valveList",valveList);


        return "kouji/addResult";
    }

    @RequestMapping(value = "/{id}/saveResult", method = RequestMethod.GET)
    public String saveResult(@PathVariable("id")String koujiId,
                             HttpSession session,
                             ModelMap modelMap){

//        tenkenRirekiService.addTenkenRireki();

        return "redirect:/kouji/"+koujiId;
    }
}
