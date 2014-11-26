package com.toyo.vc.service;

import com.toyo.vc.dao.KoujiMapper;
import com.toyo.vc.dao.KoujirelationMapper;
import com.toyo.vc.entity.Kiki;
import com.toyo.vc.entity.Kouji;
import com.toyo.vc.entity.Koujirelation;
import com.toyo.vc.entity.Valve;
import org.springframework.stereotype.Service;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
@Service
public class KoujirelationService {

    @Resource
    KoujirelationMapper koujirelationMapper;
    /**工事IDから工事情報を取得*/

    /**新規追加する*/
    public Koujirelation getKoujirelationById(String id){
        Koujirelation koujirelation=koujirelationMapper.findKoujirelationById(id);
        return koujirelation;
    }

    /**工事関連データを所得する*/
    public List<Koujirelation> getAllKoujirelationByKoujiid(String id){
        List<Koujirelation> koujirelations=koujirelationMapper.findAllKoujirelationByKoujiid(id);
        return koujirelations;
    }

    public List<Valve> getKikisysListByKoujiid(String koujiid){
         List<Valve> valves=koujirelationMapper.findKikisysListByKoujiid(koujiid);
        return valves;
    }

    public List<Kiki> getKikiListByKoujiidAndKikisys(String koujiid,String kikisysid){
        Koujirelation koujirelation=new Koujirelation();
        koujirelation.setKoujiid(Integer.valueOf(koujiid));
        koujirelation.setKikisysid(Integer.valueOf(kikisysid));
        List<Kiki> kikis=koujirelationMapper.findKikiListByKoujiidAndKikisys(koujirelation);

        return kikis;
    }

    public Koujirelation addKoujirelation(Koujirelation koujirelation){
        koujirelationMapper.insertKoujirelation(koujirelation);
        koujirelation.setId(koujirelationMapper.getLastInsertId());
        return koujirelation;
    }

    public void deleteKoujirelation(Koujirelation koujirelation){
        koujirelationMapper.deleteKoujirelation(koujirelation);
    }
}
