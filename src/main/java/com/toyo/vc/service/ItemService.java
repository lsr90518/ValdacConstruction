package com.toyo.vc.service;


import com.toyo.vc.dao.ItemMapper;
import com.toyo.vc.entity.Kiki;
import com.toyo.vc.entity.Valve;
import com.toyo.vc.dto.ValveKikiForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
@Service
public class ItemService {

    @Resource
    ItemMapper itemMapper;

    public List<Valve> getItemByLocationName(String locationName){
        List<Valve> valve=itemMapper.findByLocationName(locationName);
        return valve;
    }

    public List<Kiki> getKikiByKikisysIdSyukan(String kikiSysId,String syukan){
        ValveKikiForm valveKikiForm=new ValveKikiForm();
        valveKikiForm.setKikiSysId(kikiSysId);
        valveKikiForm.setSyukan(syukan);
        List<Kiki> kiki=itemMapper.findKikiByKikisysIdSyukan(valveKikiForm);
        return kiki;
    }

    public Valve getKikisysByKikisysId(String kikiSysId){
        Valve valve=itemMapper.findKikisysBykikisysId(kikiSysId);
        return valve;
    }

    public Kiki getKikiByKikiId(String kikiId){
        Kiki kiki=itemMapper.findKikiByKikiId(kikiId);
        return kiki;
    }


}
