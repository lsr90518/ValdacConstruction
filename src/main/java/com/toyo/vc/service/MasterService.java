package com.toyo.vc.service;

import com.toyo.vc.dao.MasterMapper;
import com.toyo.vc.entity.Master;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangrui on 2014/10/15.
 */
@Service
public class MasterService {

    @Resource
    MasterMapper masterMapper;

    public List<Master> getMasterByType(String type){
        List<Master> masterList =masterMapper.findMasterByType(type);
        return masterList;
    }
}
