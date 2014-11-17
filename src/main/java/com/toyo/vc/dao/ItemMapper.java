package com.toyo.vc.dao;

import com.toyo.vc.dto.ValveKikiForm;
import com.toyo.vc.entity.Kiki;
import com.toyo.vc.entity.Valve;

import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
public interface ItemMapper {

    public List<Valve> findByLocationName(String locationName);

    public List<Kiki> findKikiByKikisysIdSyukan(ValveKikiForm valveKikiForm);

    public Valve findKikisysBykikisysId(String kikiSysId);

    public Kiki findKikiByKikiId(String kikiId);
}
