package com.toyo.vc.dao;

import com.toyo.vc.entity.Kenan;
import com.toyo.vc.entity.TenkenRireki;
import com.toyo.vc.entity.TenkenRirekiUtil;

import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
public interface KenanMapper {

    /**IDから懸案情報を取得*/
    public Kenan findKenanById(String id);

    /**KoujiIDから懸案情報を取得*/
    public List<Kenan> findKenanByKoujiId(String koujiId);

    /**KikiIDから懸案情報を取得*/
    public List<Kenan> findKenanByKikiId(String kikiId);

    /**新規懸案を追加する*/
    public void insertKenan(Kenan kenan);

    /**最新追加した懸案のIDを取得*/
    public int getLastInsertId();
    /**懸案情報を更新する*/
    public void updateKenan(Kenan kenan);
    /**懸案情報を削除する*/
    public void deleteKenan(Kenan kenan);
}
