package com.toyo.vc.service;

import com.toyo.vc.dao.TenkenRirekiMapper;
import com.toyo.vc.entity.TenkenRirekiUtil;
import com.toyo.vc.entity.TenkenRireki;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangrui on 14/11/18.
 */
@Service
public class TenkenRirekiService {

    @Resource
    TenkenRirekiMapper tenkenRirekiMapper;

    public TenkenRireki getTenkenRirekiById(String id){
        TenkenRireki tenkenRireki = tenkenRirekiMapper.findTenkenRirekiById(id);
        return tenkenRireki;
    }

    public List<TenkenRirekiUtil> getTenkenRirekiByKoujiId(String koujiId){
        List<TenkenRirekiUtil> tenkenKikiForms= tenkenRirekiMapper.findTenkenRirekiByKoujiId(koujiId);
        return  tenkenKikiForms;
    }

    /**
     * 工事IDと完了フラグから点検機器を取得
     * 更新時間のDESC順
     * */
    public List<TenkenRirekiUtil> getTenkenRirekiByKoujiIdAndKanryoFlg(String koujiId,String kanryoFlg){
        TenkenRireki tenkenRireki=new TenkenRireki();
        tenkenRireki.setKanryoFlg(kanryoFlg);
        tenkenRireki.setKoujiId(Integer.parseInt(koujiId));

        List<TenkenRirekiUtil> tenkenKikiForms= tenkenRirekiMapper.findTenkenRirekiByKoujiIdAndKanryoFlg(tenkenRireki);
        return  tenkenKikiForms;
    }

    public TenkenRireki addTenkenRireki(TenkenRireki tenkenRireki){
        Date date=new Date();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
        tenkenRireki.setUpdDate(sdf1.format(date));
        tenkenRireki.setTrkDate(sdf1.format(date));

        tenkenRirekiMapper.insertTenkenRireki(tenkenRireki);
        tenkenRireki.setId(tenkenRirekiMapper.getLastInsertId());
        return tenkenRireki;
    }

    public TenkenRireki updateTenkenRireki(TenkenRireki tenkenRireki){
        Date date=new Date();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
        tenkenRireki.setUpdDate(sdf1.format(date));
        tenkenRirekiMapper.updateTenkenRireki(tenkenRireki);
        return tenkenRireki;
    }

    public void deleteTenkenRireki(TenkenRireki tenkenRireki){

        tenkenRirekiMapper.deleteTenkenRireki(tenkenRireki);
    }


}
