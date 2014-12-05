package com.toyo.vc.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.toyo.vc.dto.KenanForm;
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
 * Created by Lsr on 12/4/14.
 */

@Controller
@RequestMapping("/kenan")
public class KenanController {

    @Autowired
    KenanService kenanService;
    @Autowired
    TenkenRirekiService tenkenRirekiService;
    @Autowired
    ItemService itemService;
    @Autowired
    KoujirelationService koujirelationService;
    @Autowired
    KoujiService koujiService;

    @RequestMapping(value = "/addKenanByTenkenrireki", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addKenanByTenkenrireki(@RequestParam("id")String id){
        TenkenRireki tenkenRireki = tenkenRirekiService.getTenkenRirekiById(id);
        Koujirelation koujirelation = koujirelationService.getKoujirelationById(tenkenRireki.getKoujirelationId()+"");
        Valve valve = itemService.getKikisysByKikisysId(koujirelation.getKikisysid()+"");
        Kiki kiki = itemService.getKikiByKikiId(koujirelation.getKikiid()+"");
        Kouji kouji = koujiService.getKoujiById(koujirelation.getKoujiid()+"");
        KenanForm kenanForm = new KenanForm();
        kenanForm.setKoujirelationId(koujirelation.getId());
        kenanForm.setKoujiId(kouji.getId());
        kenanForm.setKikiId(kiki.getKikiId());
        kenanForm.setKiki(kiki);
        kenanForm.setValve(valve);
        kenanForm.setKouji(kouji);
        Gson gson = new Gson();

        return gson.toJson(kenanForm);
    }

    @RequestMapping(value = "/saveKenanWithForm", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveKenanWithForm(@RequestParam("kenanForm")String kenanForm){
        Gson gson = new Gson();
        List<String> kenanData = gson.fromJson(kenanForm, new TypeToken<List<String>>(){}.getType());
        Kenan kenan = new Kenan();
        kenan.setKoujiId(Integer.valueOf(kenanData.get(0)));
        kenan.setKoujirelationId(Integer.valueOf(kenanData.get(1)));
        kenan.setKikiId(Integer.valueOf(kenanData.get(2)));
        kenan.setJisyo(kenanData.get(3));
        kenan.setBuhin(kenanData.get(4));
        kenan.setGensyo(kenanData.get(5));
        kenan.setTaisaku(kenanData.get(6));
        kenan.setHakkenJyokyo(kenanData.get(7));
        kenan.setYouin(kenanData.get(8));
        kenan.setSyotiNaiyou(kenanData.get(9));
        kenan.setHakkenDate(kenanData.get(10));
        kenan.setTaisakuDate(kenanData.get(11));
        kenan.setTaiouFlg(kenanData.get(12));
        kenanService.addKenan(kenan);
        return "";
    }

    @RequestMapping(value = "/getKenanByIdInSession", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getKenanByIdInSession(@RequestParam("id")String id, HttpSession session){
        List<KenanForm> kenanFormList = (List<KenanForm>) session.getAttribute("kenanFormList");
        KenanForm kenanForm = new KenanForm();
        for (int i = 0; i < kenanFormList.size(); i++) {
            if(kenanFormList.get(i).getId() == Integer.valueOf(id)){
                kenanForm = kenanFormList.get(i);
                break;
            }
        }

        Gson gson = new Gson();
        return gson.toJson(kenanForm);
    }

    @RequestMapping(value = "/updateKenan", method = RequestMethod.POST)
    public String updateKenanByForm(@ModelAttribute("kenanForm")KenanForm kenanForm){
        kenanService.updateKenan(kenanForm);
        return "redirect:/kouji/"+kenanForm.getKoujiId()+"/kenan";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id")String id){
        Kenan kenan = kenanService.getKenanById(id);
        kenanService.deleteKenan(kenan);
        return "redirect:/kouji/"+kenan.getKoujiId()+"/kenan";
    }
}
