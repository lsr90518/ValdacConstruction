package com.toyo.vc.dao;

import com.toyo.vc.entity.Kouji;

import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
public interface KoujiMapper {

    /**該ユーザが担当している工事リストを取得*/
    public Kouji findKoujiById(String id);

    /**該ユーザが担当している工事リストを取得*/
    public List<Kouji> findKoujiByperson(String username);
    public List<Kouji> findByPersonAndKoujiStatus(Kouji kouji);
    /**該ユーザが担当している最新の工事リストのトップ１０を取得*/
    public List<Kouji> findLastedTenKoujiByperson(String username);
    public List<Kouji> findLastedTenKoujiBypersonAndKoujiStatus(Kouji kouji);

    /**該ユーザが最近更新した工事リストのトップ１０を取得*/
    public List<Kouji> findUpdateTenKoujiByperson(String username);
    public List<Kouji> findUpdateTenKoujiBypersonAndKoujiStatus(Kouji kouji);

    /**新規工事をkoujiテーブルに追加する*/
    public void insertKouji(Kouji kouji);
    /**最新追加した工事のIDを取得*/
    public int getLastInsertId();
    /**工事情報を更新する*/
    public void updateKouji(Kouji kouji);
    /**工事情報を削除する*/
    public void deleteKouji(Kouji kouji);
}
