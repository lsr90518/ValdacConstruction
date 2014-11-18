package com.toyo.vc.service;

import com.toyo.vc.dao.LocationMapper;
import com.toyo.vc.entity.Location;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangrui on 14/11/12.
 */
@Service
public class LocationService {

    @Resource
    LocationMapper locationMapper;

    public List<Location> getAllLocation(){
        List<Location> locationList = locationMapper.findAllLocation();
        return locationList;
    }

    public List<String> getKCodeL(){
        List<String> kCodeLList = locationMapper.findKCodeL();
        return kCodeLList;
    }

    public List<String> getKCodeMByL(String kCodeL){
        Location location=new Location();
        location.setkCodeL(kCodeL);
        List<String> kCodeMList = locationMapper.findKCodeMByL(location);
        return kCodeMList;
    }

    public List<String> getKCodeSByLM(String kCodeL,String kCodeM){
        Location location=new Location();
        location.setkCodeL(kCodeL);
        location.setkCodeM(kCodeM);
        List<String> kCodeSList = locationMapper.findKCodeSByLM(location);
        return kCodeSList;
    }

}
