package com.toyo.vc.controller;

import com.toyo.vc.entity.*;
import com.toyo.vc.service.KenanService;
import com.toyo.vc.service.KoujiService;
import com.toyo.vc.service.TenkenRirekiService;
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
    @Autowired
    TenkenRirekiService tenkenRirekiService;
    @Autowired
    KenanService kenanService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpSession session, ModelMap modelMap){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "login";
        } else {
            if(user.getKengen().equals("6")){
                List<Kouji> lastedKoujiList = koujiService.getLastedTenKoujiByPerson(user.getUsername());
                List<Kouji> updatedKoujiList = koujiService.getUpdateTenKoujiByPerson(user.getUsername());
                modelMap.addAttribute("lastedKoujiList",lastedKoujiList);
                modelMap.addAttribute("updatedKoujiList",updatedKoujiList);

                List<TenkenRirekiUtil> tenkenRirekiList=null;
                if(lastedKoujiList.size()>0){
                    tenkenRirekiList = tenkenRirekiService.getTenkenRirekiByKoujiId(lastedKoujiList.get(0).getId()+"");
                    if(tenkenRirekiList.size()>10){
                        tenkenRirekiList = tenkenRirekiList.subList(0,10);
                    }
                }
                modelMap.addAttribute("tenkenRirekiHistory",tenkenRirekiList);

            } else {
                List<Kouji> lastedKoujiList = koujiService.getLastedTenKoujiByPerson(user.getUserid());
                List<Kouji> updatedKoujiList = koujiService.getUpdateTenKoujiByPerson(user.getUserid());
                modelMap.addAttribute("lastedKoujiList",lastedKoujiList);
                modelMap.addAttribute("updatedKoujiList",updatedKoujiList);

                List<TenkenRirekiUtil> tenkenRirekiList=null;
                if(lastedKoujiList.size()>0){
                    tenkenRirekiList = tenkenRirekiService.getTenkenRirekiByKoujiId(lastedKoujiList.get(0).getId()+"");
                    if(tenkenRirekiList.size()>10){
                        tenkenRirekiList = tenkenRirekiList.subList(0,10);
                    }
                }
                modelMap.addAttribute("tenkenRirekiHistory",tenkenRirekiList);
            }
            return "index";
        }
    }
}
