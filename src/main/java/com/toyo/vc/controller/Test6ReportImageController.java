package com.toyo.vc.controller;

import com.google.gson.Gson;
import com.toyo.vc.entity.Kenan;
import com.toyo.vc.entity.ReportImage;
import com.toyo.vc.service.KenanService;
import com.toyo.vc.service.ReportImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/testReportImage")
public class Test6ReportImageController {

    @Autowired
    private ReportImageService reportImageService;

    @RequestMapping(value="/getReportImageById",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getReportImageById(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        String id="1";
        ReportImage reportImage=reportImageService.getReportImageById(id);
        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(reportImage));
        return "zuitest";
    }

    @RequestMapping(value="/getReportImageByKoujiId",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getReportImageByKoujiId(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        String koujiId="304";

        List<ReportImage> reportImages=reportImageService.getReportImageByKoujiId(koujiId);
        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(reportImages));
        return "zuitest";
    }



    @RequestMapping(value="/addReportImage",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String addReportImage(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        ReportImage reportimage=new ReportImage();

        reportimage.setKoujiId(304);
        reportimage.setImagesyu("画像種別");
        reportimage.setPage(1);
        reportimage.setImagename("testImage");
        reportimage.setPapersize("A4");

        ReportImage newReportImage=reportImageService.addReportImage(reportimage);

        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(newReportImage));
        return "zuitest";
    }

    @RequestMapping(value="/updateReportImage",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String updateReportImage(ModelMap model) {
        model.addAttribute("message", "Hello world!");

        ReportImage reportimage=new ReportImage();

        reportimage.setId(1);
        reportimage.setKoujiId(304);
        reportimage.setImagesyu("画像種別q");
        reportimage.setPage(2);
        reportimage.setImagename("testImage2");
        reportimage.setPapersize("A4A3");

        ReportImage newReportImage=reportImageService.updateReportImage(reportimage);

        Gson gsonvalves = new Gson();
        model.addAttribute("message", gsonvalves.toJson(newReportImage));
        return "zuitest";
    }
    @RequestMapping(value="/deleteReportImage",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String deleteReportImage(ModelMap model){
        ReportImage reportimage=new ReportImage();

        reportimage.setId(1);
        reportImageService.deleteReportImage(reportimage);
        model.addAttribute("message", "reportImageを削除されました");
        return "zuitest";
    }

}