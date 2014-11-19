package com.toyo.vc.controller;

import com.google.gson.Gson;
import com.toyo.vc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Lsr on 11/12/14.
 */

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/getKCodeLJson", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getKCodeL(){
        List<String> kCodeLList = locationService.getKCodeL();
        Gson gson = new Gson();
        return gson.toJson(kCodeLList);
    }

    @RequestMapping(value = "/getKcodeMJsonBykCodeL", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getKCodeMByKCodeL(@RequestParam("kCodeL")String kCodeL){
        List<String> kCodeMList = locationService.getKCodeMByL(kCodeL);
        Gson gson = new Gson();
        return gson.toJson(kCodeMList);
    }

    @RequestMapping(value = "/getKcodeSJsonBykCodeLkCodeM", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getKcodeSJsonBykCodeLkCodeM(@RequestParam("kCodeL")String kCodeL,
                                              @RequestParam("kCodeM")String kCodeM){
        List<String> kCodeSList = locationService.getKCodeSByLM(kCodeL,kCodeM);
        Gson gson = new Gson();
        return gson.toJson(kCodeSList);
    }
}
