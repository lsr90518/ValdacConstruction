package com.toyo.vc.controller;

import com.toyo.vc.dto.KoujiForm;
import com.toyo.vc.dto.ValveKikiSelectUtil;
import com.toyo.vc.entity.*;
import com.toyo.vc.service.*;
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
    @Autowired
    KenanService kenanService;


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
        koujiForm.setStatus("未完成");
        Kouji kouji = koujiService.addKouji(koujiForm);
        List<Valve> valveList = itemService.getItemByLocationName(kouji.getLocation());
        modelMap.addAttribute("kouji",kouji);
        modelMap.addAttribute("valveList",valveList);
        return "/kouji/addValve";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getKoujiById(@PathVariable("id")String id, ModelMap modelMap,HttpSession session){
        Kouji kouji = koujiService.getKoujiById(id);
        List<TenkenRirekiUtil> tenkenRirekiUtilList = tenkenRirekiService.getTenkenRirekiByKoujiId(id);

        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            Koujirelation koujirelation = koujirelationService.getKoujirelationById(tenkenRirekiUtilList.get(i).getKoujirelationId() + "");
            Valve valve = itemService.getKikisysByKikisysId(koujirelation.getKikisysid() + "");
            tenkenRirekiUtilList.get(i).setValve(valve);
        }

        //make cache
        session.setAttribute("tenkenRirekiUtilList",tenkenRirekiUtilList);

        modelMap.addAttribute("kouji", kouji);
        return "/kouji/index";
    }

    @RequestMapping(value = "/{id}/instruct", method = RequestMethod.GET)
    public String getInstruct(@PathVariable("id")String id, ModelMap modelMap, HttpSession session){
        Kouji kouji = koujiService.getKoujiById(id);
        List<TenkenRirekiUtil> tenkenRirekiUtilList = tenkenRirekiService.getTenkenRirekiByKoujiId(id);

        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            Koujirelation koujirelation = koujirelationService.getKoujirelationById(tenkenRirekiUtilList.get(i).getKoujirelationId() + "");
            Valve valve = itemService.getKikisysByKikisysId(koujirelation.getKikisysid() + "");
            tenkenRirekiUtilList.get(i).setValve(valve);
        }

        //make cache
        session.setAttribute("tenkenRirekiUtilList",tenkenRirekiUtilList);

        modelMap.addAttribute("kouji", kouji);
        return "/kouji/instruct";
    }

    @RequestMapping(value = "/{id}/history", method = RequestMethod.GET)
    public String getHistoryById(@PathVariable("id")String id, ModelMap modelMap, HttpSession session){
        Kouji kouji = koujiService.getKoujiById(id);
        modelMap.addAttribute("kouji",kouji);

        List<TenkenRirekiUtil> tenkenRirekiUtilList = tenkenRirekiService.getTenkenRirekiByKoujiId(id);
        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            Koujirelation koujirelation = koujirelationService.getKoujirelationById(tenkenRirekiUtilList.get(i).getKoujirelationId() + "");
            Valve valve = itemService.getKikisysByKikisysId(koujirelation.getKikisysid() + "");
            tenkenRirekiUtilList.get(i).setValve(valve);
        }

        //make cache
        session.setAttribute("tenkenRirekiHistory",tenkenRirekiUtilList);
        return "/kouji/history";
    }

    @RequestMapping(value = "/{id}/kenan", method = RequestMethod.GET)
    public String getKenanByKoujiId(@PathVariable("id")String id, ModelMap modelMap, HttpSession session){
        Kouji kouji = koujiService.getKoujiById(id);
        modelMap.addAttribute("kouji",kouji);

        List<Kenan> kenanList = kenanService.getKenanByKoujiId(id);
        modelMap.addAttribute("kenanList",kenanList);
        return "/kouji/kenan";
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
        List<Koujirelation> koujirelationList = koujirelationService.getAllKoujirelationByKoujiid(koujiId);
        for (int i = 0; i < koujirelationList.size(); i++) {
            if(koujirelationList.get(i).getKikiid() > 0) {
                TenkenRireki tenkenRireki = new TenkenRireki();
                tenkenRireki.setKoujiId(Integer.valueOf(koujiId));
                tenkenRireki.setKikiId(koujirelationList.get(i).getKikiid());
                tenkenRireki.setKoujirelationId(koujirelationList.get(i).getId());
                tenkenRireki.setTenkenkekka("");
                tenkenRireki.setTenkenRank("");
                tenkenRireki.setTenkennaiyo("");

                tenkenRirekiService.addTenkenRireki(tenkenRireki);
            }
        }
        session.removeAttribute(koujiId);

        return "redirect:/kouji/"+koujiId;
    }

    @RequestMapping(value = "/updateKouji", method = RequestMethod.POST)
    public String updateKouji(@ModelAttribute("KoujiForm")KoujiForm koujiForm, ModelMap modelMap){
        koujiService.updateKouji(koujiForm);
        return "redirect:/kouji/"+koujiForm.getId();
    }

}
