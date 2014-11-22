package com.toyo.vc.service;

import com.google.gson.Gson;
import com.toyo.vc.dao.ReportImageMapper;
import com.toyo.vc.entity.ReportImage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangrui on 19/11/14.
 */
@Service
public class ReportImageService {

    @Resource
    ReportImageMapper reportImageMapper;
    /**IDから画像情報を取得*/
    public ReportImage getReportImageById(String id){

        ReportImage reportImage=reportImageMapper.findReportImageById(id);
        return  reportImage;
    }

    /**工事の画像リストを取得*/
    public List<ReportImage> getReportImageByKoujiId(String koujiId){

        List<ReportImage> reportImages=reportImageMapper.findReportImageByKoujiId(koujiId);
        return  reportImages;
    }


    /**新規画像テーブルに追加する*/
    public ReportImage addReportImage(ReportImage reportImage){
        //append Date
        Date date=new Date();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
        reportImage.setTrkDate(sdf1.format(date));
        reportImage.setUpdDate(sdf1.format(date));


        String koujiId=Integer.toString(reportImage.getKoujiId());
        System.out.println(koujiId);
        List<ReportImage> temReportImages=reportImageMapper.findReportImageByKoujiId(koujiId);
        Gson gsonvalves = new Gson();
        System.out.println(gsonvalves.toJson(temReportImages));

        if((temReportImages.size()>0)){
            System.out.println("not null");
            reportImage.setPage((reportImageMapper.getLastPageByKoujiId(koujiId))+1);
        }else{
            System.out.println("null");
            reportImage.setPage(1);
        }
        reportImageMapper.insertReportImage(reportImage);
        //make id
        reportImage.setId(reportImageMapper.getLastInsertId());
        return reportImage;
    }
    /**画像を更新する*/
    public ReportImage updateReportImage(ReportImage reportImage){
        Date date=new Date();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
        reportImage.setUpdDate(sdf1.format(date));

        reportImageMapper.updateReportImage(reportImage);
        return reportImage;
    }

    /**画像を削除する*/
    public void deleteReportImage(ReportImage reportImage){
        reportImageMapper.deleteReportImage(reportImage);
    }
}
