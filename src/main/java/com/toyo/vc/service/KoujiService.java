package com.toyo.vc.service;

import com.toyo.vc.dao.KoujiMapper;
import com.toyo.vc.entity.Kouji;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
@Service
public class KoujiService {

    @Resource
    KoujiMapper koujiMapper;

    public List<Kouji> getKoujiByResponsibility(String userid){

        List<Kouji> kouji=koujiMapper.findByUserId(userid);
        return  kouji;
    }

    public List<Kouji> getLastedTenKoujiByResponsibility(String userid){

        List<Kouji> kouji=koujiMapper.findLastedTenKoujiByResponsibility(userid);
        return  kouji;
    }

    public List<Kouji> getUpdateTenKoujiByResponsibility(String userid){

        List<Kouji> kouji=koujiMapper.findUpdateTenKoujiByResponsibility(userid);
        return  kouji;
    }

    public Kouji addKouji(Kouji kouji){
        //append Date
        Date date=new Date();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
        kouji.setTrkDate(sdf1.format(date));
        kouji.setUpdDate(sdf1.format(date));

        koujiMapper.insertKouji(kouji);
        //make id
        kouji.setId(koujiMapper.getLastInsertId());
        return kouji;
    }
}
