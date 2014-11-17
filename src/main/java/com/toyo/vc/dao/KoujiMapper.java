package com.toyo.vc.dao;

import com.toyo.vc.entity.Kouji;

import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
public interface KoujiMapper {

    /**該ユーザが担当している工事リストを取得*/
    public List<Kouji> findByUserId(String userid);
    /**該ユーザが担当している最新の工事リストのトップ１０を取得*/
    public List<Kouji> findLastedTenKoujiByResponsibility(String userid);
    /**該ユーザが最近更新した工事リストのトップ１０を取得*/
    public List<Kouji> findUpdateTenKoujiByResponsibility(String userid);
    /**新規工事をkoujiテーブルに追加する*/
    public void insertKouji(Kouji kouji);
    /**最新追加した工事のIDを取得*/
    public int getLastInsertId();
    /**工事情報を更新する*/
    public void updateKouji(Kouji kouji);
    /**工事情報を削除する*/
    public void deleteKouji(Kouji kouji);
}