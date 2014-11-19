package com.toyo.vc.dao;

import com.toyo.vc.entity.ReportImage;

import java.util.List;

/**
 * Created by zhangrui on 19/11/14.
 */
public interface ReportImageMapper {

    /**IDから画像情報を取得*/
    public ReportImage findReportImageById(String id);

    /**工事の画像リストを取得*/
    public List<ReportImage> findReportImageByKoujiId(String koujiId);

    /**新規画像テーブルに追加する*/
    public void insertReportImage(ReportImage reportImage);

    /**最新追加した画像のIDを取得*/
    public int getLastInsertId();

    /**工事の最後のPage数を取得*/
    public int getLastPageByKoujiId(String koujiId);

    /**画像を更新する*/
    public void updateReportImage(ReportImage reportImage);
    /**画像を削除する*/
    public void deleteReportImage(ReportImage reportImage);
}
