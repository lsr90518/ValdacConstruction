package com.toyo.vc.controller;

import com.google.gson.Gson;
import com.toyo.vc.entity.TenkenRireki;
import com.toyo.vc.entity.TenkenRirekiUtil;
import com.toyo.vc.entity.Valve;
import com.toyo.vc.service.TenkenRirekiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lsr on 11/26/14.
 */

@Controller
@RequestMapping("/tenken")
public class TenkenController {

    @Autowired
    TenkenRirekiService tenkenRirekiService;

    @RequestMapping(value = "/saveTenkenrank", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveTenkenrank(@RequestParam("id")String rirekiId,
                                  @RequestParam("tenkenrank")String tenkenrank,
                                  HttpSession session){
        TenkenRireki tenkenRireki = tenkenRirekiService.getTenkenRirekiById(rirekiId);
        if(tenkenrank.length() < 1) {
            tenkenRireki.setKanryoFlg("未完成");
        } else {
            tenkenRireki.setTenkenRank(tenkenrank);
            tenkenRireki.setKanryoFlg("完成");
        }

        List<TenkenRirekiUtil> tenkenRirekiUtilList = (List<TenkenRirekiUtil>) session.getAttribute("tenkenRirekiUtilList");
        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            if(tenkenRireki.getId() == tenkenRirekiUtilList.get(i).getId()){
                if(tenkenrank.length() < 1) {
                    tenkenRirekiUtilList.get(i).setKanryoFlg("未完成");
                } else {
                    tenkenRirekiUtilList.get(i).setKanryoFlg("完成");
                    tenkenRirekiUtilList.get(i).setTenkenRank(tenkenrank);
                }
                break;
            }
        }
        session.setAttribute("tenkenRirekiUtilList",tenkenRirekiUtilList);
        tenkenRirekiService.updateTenkenRireki(tenkenRireki);
        return tenkenRireki.getKanryoFlg();
    }
    @RequestMapping(value = "/saveTenkenkekka", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveTenkenkekka(@RequestParam("id")String rirekiId,
                                  @RequestParam("tenkenkekka")String tenkenkekka,
                                  HttpSession session){
        TenkenRireki tenkenRireki = tenkenRirekiService.getTenkenRirekiById(rirekiId);
        String result = "";
        if(tenkenRireki.getTenkenkekka() == null){
            tenkenRireki.setTenkenkekka(tenkenkekka);
            tenkenRirekiService.updateTenkenRireki(tenkenRireki);
            result = "1";
        } else {
            if (!tenkenRireki.getTenkenkekka().equals(tenkenkekka)) {
                tenkenRireki.setTenkenkekka(tenkenkekka);
                tenkenRirekiService.updateTenkenRireki(tenkenRireki);
                result = "1";
            } else {
                result = "0";
            }
        }

        // update session cache
        List<TenkenRirekiUtil> tenkenRirekiUtilList = (List<TenkenRirekiUtil>) session.getAttribute("tenkenRirekiUtilList");
        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            if(tenkenRireki.getId() == tenkenRirekiUtilList.get(i).getId()){
                if(result == "1") {
                    tenkenRirekiUtilList.get(i).setTenkenkekka(tenkenkekka);
                }
                break;
            }
        }
        session.setAttribute("tenkenRirekiUtilList",tenkenRirekiUtilList);

        return result;
    }

    @RequestMapping(value = "/getTenkenrirekiByPage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getTenkenrirekiByPage(@RequestParam("currentPage")String currentPage,
                                        HttpSession session){

        List<TenkenRirekiUtil> tenkenRirekiUtilList = (List<TenkenRirekiUtil>) session.getAttribute("tenkenRirekiUtilList");
        //page control
        int countInOnePage = 20;
        int pageCount = 0;
        int currentIndex = countInOnePage * Integer.valueOf(currentPage);
        List<TenkenRirekiUtil> tenkenRirekiUtils = new ArrayList<TenkenRirekiUtil>();
        pageCount = tenkenRirekiUtilList.size()/countInOnePage;
        if(tenkenRirekiUtilList.size()%countInOnePage != 0){
            pageCount++;
        }
        int addCount = currentIndex + countInOnePage;
        if(tenkenRirekiUtilList.size() < addCount){
            addCount = tenkenRirekiUtilList.size();
        }
        for (int i = currentIndex; i < addCount; i++) {
            tenkenRirekiUtils.add(tenkenRirekiUtilList.get(i));
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("pageCount", pageCount);
        result.put("currentPage", Integer.valueOf(currentPage));
        result.put("tenkenRirekiList", tenkenRirekiUtils);

        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @RequestMapping(value = "/getTenkenrirekiHitoryByPage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getTenkenrirekiHitoryByPage(@RequestParam("currentPage")String currentPage,
                                              HttpSession session){
        List<TenkenRirekiUtil> tenkenRirekiUtilList = (List<TenkenRirekiUtil>) session.getAttribute("tenkenRirekiHistory");
        //page control
        int countInOnePage = 10;
        int pageCount = 0;
        int currentIndex = countInOnePage * Integer.valueOf(currentPage);
        List<TenkenRirekiUtil> tenkenRirekiUtils = new ArrayList<TenkenRirekiUtil>();
        pageCount = tenkenRirekiUtilList.size()/countInOnePage;
        if(tenkenRirekiUtilList.size()%countInOnePage != 0){
            pageCount++;
        }
        int addCount = currentIndex + countInOnePage;
        if(tenkenRirekiUtilList.size() < addCount){
            addCount = tenkenRirekiUtilList.size();
        }
        for (int i = currentIndex; i < addCount; i++) {
            tenkenRirekiUtils.add(tenkenRirekiUtilList.get(i));
        }

        Map<String,Object> result = new HashMap<String, Object>();
        result.put("pageCount", pageCount);
        result.put("currentPage", Integer.valueOf(currentPage));
        result.put("tenkenRirekiList", tenkenRirekiUtils);

        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @RequestMapping(value = "/getListNumber", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getListNumber(HttpSession session){
        List<TenkenRirekiUtil> tenkenRirekiUtilList = (List<TenkenRirekiUtil>) session.getAttribute("tenkenRirekiUtilList");
        int total = tenkenRirekiUtilList.size();
        int complete = 0;
        int incomplete = 0;
        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            if(tenkenRirekiUtilList.get(i).getKanryoFlg().equals("完成")){
                complete++;
            } else {
                incomplete++;
            }
        }

        Map<String, Integer> numbers = new HashMap<String, Integer>();
        numbers.put("total",total);
        numbers.put("complete",complete);
        numbers.put("incomplete",incomplete);
        Gson gson = new Gson();
        return gson.toJson(numbers);
    }

    @RequestMapping(value = "/saveTenkennaiyo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveTenkennaiyo(@RequestParam("id")String rirekiId,
                                  @RequestParam("tenkennaiyo")String tenkennaiyo,
                                  HttpSession session){
        TenkenRireki tenkenRireki = tenkenRirekiService.getTenkenRirekiById(rirekiId);
        tenkenRireki.setTenkennaiyo(tenkennaiyo);


        List<TenkenRirekiUtil> tenkenRirekiUtilList = (List<TenkenRirekiUtil>) session.getAttribute("tenkenRirekiUtilList");
        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            if(tenkenRireki.getId() == tenkenRirekiUtilList.get(i).getId()){
                tenkenRireki.setTenkennaiyo(tenkennaiyo);
                break;
            }
        }
        session.setAttribute("tenkenRirekiUtilList",tenkenRirekiUtilList);
        tenkenRirekiService.updateTenkenRireki(tenkenRireki);
        return "";

    }

    @RequestMapping(value = "/getNaiyoNumbers", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getNaiyoNumbers(HttpSession session){
        List<TenkenRirekiUtil> tenkenRirekiUtilList = (List<TenkenRirekiUtil>) session.getAttribute("tenkenRirekiUtilList");
        int total = tenkenRirekiUtilList.size();
        int complete = 0;
        int incomplete = 0;
        for (int i = 0; i < tenkenRirekiUtilList.size(); i++) {
            if(tenkenRirekiUtilList.get(i).getTenkennaiyo().length() > 0){
                complete++;
            } else {
                incomplete++;
            }
        }

        Map<String, Integer> numbers = new HashMap<String, Integer>();
        numbers.put("total",total);
        numbers.put("complete",complete);
        numbers.put("incomplete",incomplete);
        Gson gson = new Gson();
        return gson.toJson(numbers);
    }
}
