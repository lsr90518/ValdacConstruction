package com.toyo.vc.service;

import com.ValdacBeta.dao.MasterMapper;
import com.ValdacBeta.entity.Master;
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
