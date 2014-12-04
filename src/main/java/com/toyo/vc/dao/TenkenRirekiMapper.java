package com.toyo.vc.dao;

import com.toyo.vc.entity.TenkenRirekiUtil;
import com.toyo.vc.entity.TenkenRireki;

import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
public interface TenkenRirekiMapper {

    /**IDから点検機器情報を取得*/
    public TenkenRireki findTenkenRirekiById(String id);

    /**KoujiIDから点検機器情報を取得*/
    public List<TenkenRirekiUtil> findTenkenRirekiByKoujiId(String koujiId);

    /**KoujiID,statusから点検機器情報を取得*/
    public List<TenkenRirekiUtil> findTenkenRirekiByKoujiIdAndKanryoFlg(TenkenRireki tenkenRireki);

    /**新規点検機器を追加する*/
    public void insertTenkenRireki(TenkenRireki tenkenRireki);

    /**最新追加した工事のIDを取得*/
    public int getLastInsertId();
    /**工事情報を更新する*/
    public void updateTenkenRireki(TenkenRireki tenkenRireki);
    /**工事情報を削除する*/
    public void deleteTenkenRireki(TenkenRireki tenkenRireki);
}
