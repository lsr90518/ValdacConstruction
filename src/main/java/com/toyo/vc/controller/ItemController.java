package com.toyo.vc.controller;

import com.google.gson.Gson;
import com.toyo.vc.dto.ValveKikiSelectUtil;
import com.toyo.vc.entity.Kiki;
import com.toyo.vc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lsr on 11/22/14.
 */

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/getKikiByKikiSysId", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getKikiByKikiSysId(@RequestParam("koujiId")String koujiId,
                                     @RequestParam("kikiSysId")String kikiSysId,
                                     @RequestParam("syukan")String syukan,
                                     HttpSession session){

        //getFromSession
        List<ValveKikiSelectUtil> valveKikiSelectUtilList = (List<ValveKikiSelectUtil>) session.getAttribute(koujiId);
        List<ValveKikiSelectUtil> vksuList = new ArrayList<ValveKikiSelectUtil>();
        //如果没有缓存
        if(valveKikiSelectUtilList == null) {
            List<Kiki> kikiList = itemService.getKikiByKikisysIdSyukan(kikiSysId, syukan);
            valveKikiSelectUtilList = new ArrayList<ValveKikiSelectUtil>();

            for (int i = 0; i < kikiList.size(); i++) {
                ValveKikiSelectUtil valveKikiSelectUtil = new ValveKikiSelectUtil();
                valveKikiSelectUtil.setKiki(kikiList.get(i));
                valveKikiSelectUtil.setId(koujiId);
                valveKikiSelectUtil.setKikiSysId(kikiSysId);
                valveKikiSelectUtil.setStatus("");
                valveKikiSelectUtilList.add(valveKikiSelectUtil);
            }

            session.setAttribute(koujiId, valveKikiSelectUtilList);
            for (int i = 0; i < valveKikiSelectUtilList.size(); i++) {
                if(valveKikiSelectUtilList.get(i).getKikiSysId().equals(kikiSysId)){
                    vksuList.add(valveKikiSelectUtilList.get(i));
                }
            }
        } else {
            //有缓存session
            for (int i = 0; i < valveKikiSelectUtilList.size(); i++) {
                if(valveKikiSelectUtilList.get(i).getKikiSysId().equals(kikiSysId)){
                    vksuList.add(valveKikiSelectUtilList.get(i));
                }
            }
            //无缓存kikiSysId
            if(vksuList.size() < 1){
                List<Kiki> kikiList = itemService.getKikiByKikisysIdSyukan(kikiSysId, syukan);

                for (int i = 0; i < kikiList.size(); i++) {
                    ValveKikiSelectUtil valveKikiSelectUtil = new ValveKikiSelectUtil();
                    valveKikiSelectUtil.setKiki(kikiList.get(i));
                    valveKikiSelectUtil.setId(koujiId);
                    valveKikiSelectUtil.setKikiSysId(kikiSysId);
                    valveKikiSelectUtil.setStatus("");
                    valveKikiSelectUtilList.add(valveKikiSelectUtil);
                }

                session.setAttribute(koujiId, valveKikiSelectUtilList);
                for (int i = 0; i < valveKikiSelectUtilList.size(); i++) {
                    if(valveKikiSelectUtilList.get(i).getKikiSysId().equals(kikiSysId)){
                        vksuList.add(valveKikiSelectUtilList.get(i));
                    }
                }
            }
        }

        Gson gson = new Gson();

        return gson.toJson(vksuList);
    }

    @RequestMapping(value = "/saveStatusToSession", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveStatusToSession(@RequestParam("koujiId")String koujiId,
                                      @RequestParam("kikiSysId")String kikiSysId,
                                      @RequestParam("kikiId")String kikiId,
                                      @RequestParam("status")String status,
                                      HttpSession session){
        //getFromSession
        List<ValveKikiSelectUtil> valveKikiSelectUtilList = (List<ValveKikiSelectUtil>) session.getAttribute(koujiId);
        for(int i = 0;i<valveKikiSelectUtilList.size();i++){
            String vId = valveKikiSelectUtilList.get(i).getKikiSysId();
            String kId = valveKikiSelectUtilList.get(i).getKiki().getKikiId()+"";
            if(kId.equals(kikiId) && vId.equals(kikiSysId)){
                valveKikiSelectUtilList.get(i).setStatus(status);
                break;
            }
        }
        session.setAttribute(koujiId, valveKikiSelectUtilList);

        return "";
    }

}
