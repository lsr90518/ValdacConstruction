package com.toyo.vc.controller;

import com.toyo.vc.entity.ReportImage;
import com.toyo.vc.service.ReportImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lsr on 12/5/14.
 */

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ReportImageService reportImageService;

    @RequestMapping(value = "/saveImageByImagePath", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveImageByImagePath(@RequestParam("object")String object,
                                       @RequestParam("koujiId")String koujiId,
                                       HttpSession session,
                                       ModelMap modelMap){
        ReportImage reportImage = new ReportImage();
        reportImage.setKoujiId(Integer.valueOf(koujiId));
        reportImage.setImagename(object);
        reportImage.setImagesyu("");
        reportImage.setPapersize("A4");
        reportImage.setImagesyu("");
        reportImageService.addReportImage(reportImage);
        return "";
    }

    @RequestMapping(value = "/updateSyuByImagename", method = RequestMethod.POST, produces = "html/text;charset=UTF-8")
    @ResponseBody
    public String updateSyuByImagename(@RequestParam("imagesyu")String imagesyu,
                                       @RequestParam("object")String object){

        ReportImage reportImage = reportImageService.getReportImageByImagename(object);
        reportImage.setImagesyu(imagesyu);
        reportImageService.updateReportImage(reportImage);
        return "";
    }

    @RequestMapping(value = "/updateSyuById", method = RequestMethod.POST, produces = "html/text;charset=UTF-8")
    @ResponseBody
    public String updateSyuById(@RequestParam("imagesyu")String imagesyu,
                                       @RequestParam("object")String object){
        ReportImage reportImage = reportImageService.getReportImageByImagename(object);
        reportImage.setImagesyu(imagesyu);
        reportImageService.updateReportImage(reportImage);
        return "";
    }

    @RequestMapping(value = "/deleteByImagename", method = RequestMethod.POST, produces = "html/text;charset=UTF-8")
    @ResponseBody
    public String deleteByImagename(@RequestParam("object")String object){
        ReportImage reportImage = reportImageService.getReportImageByImagename(object);
        reportImageService.deleteReportImage(reportImage);
        return object;
    }

}
