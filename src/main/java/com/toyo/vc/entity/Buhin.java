package com.toyo.vc.entity;

/**
 * Created by Lsr on 10/18/14.
 */
public class Buhin {
    public int buhinId;
    public String buhinKbn;
    public String BuhinSeq;
    public String asbKbn;
    public String buhinzuBikou;
    public String buhinMei;
    public String hyojunSiyou;
    public String siyouKasyo;
    public String makerRyaku;
    public String sizaiName;
    public String maker;
    public String sunpou;
    public String hinban;
    public String bikou;
    public String suryo;
    public String imageId;
    public String trkDate;
    public String updDate;//hinban


    public String toText(){
        String text =
                buhinKbn+" "+
                asbKbn+" "+
                buhinzuBikou+" "+
                buhinMei+" "+
                hyojunSiyou+" "+
                siyouKasyo+" "+
                makerRyaku+" "+
                maker+" "+
                sizaiName+" "+
                sunpou+" "+
                suryo+" "+
                hinban+" "+
                bikou+" ";

        return text;
    }

    public int getTrkDateInt(){
        String intDate[] = trkDate.split("/");
        String result = "";
        for (int i = 0; i < intDate.length; i++) {
            result = result + intDate[i];
        }
        return Integer.valueOf(result);
    }
    public int getUpdDateInt(){
        String intDate[] = updDate.split("/");
        String result = "";
        for (int i = 0; i < intDate.length; i++) {
            result = result + intDate[i];
        }
        return Integer.valueOf(result);
    }

    public int getBuhinId() {
        return buhinId;
    }

    public void setBuhinId(int buhinId) {
        this.buhinId = buhinId;
    }

    public String getBuhinKbn() {
        return buhinKbn;
    }

    public void setBuhinKbn(String buhinKbn) {
        this.buhinKbn = buhinKbn;
    }

    public String getBuhinSeq() {
        return BuhinSeq;
    }

    public void setBuhinSeq(String buhinSeq) {
        BuhinSeq = buhinSeq;
    }

    public String getSiyouKasyo() {
        return siyouKasyo;
    }

    public void setSiyouKasyo(String siyouKasyo) {
        this.siyouKasyo = siyouKasyo;
    }

    public String getAsbKbn() {
        return asbKbn;
    }

    public void setAsbKbn(String asbKbn) {
        this.asbKbn = asbKbn;
    }

    public String getBuhinzuBikou() {
        return buhinzuBikou;
    }

    public void setBuhinzuBikou(String buhinzuBikou) {
        this.buhinzuBikou = buhinzuBikou;
    }

    public String getBuhinMei() {
        return buhinMei;
    }

    public void setBuhinMei(String buhinMei) {
        this.buhinMei = buhinMei;
    }

    public String getHyojunSiyou() {
        return hyojunSiyou;
    }

    public void setHyojunSiyou(String hyojunSiyou) {
        this.hyojunSiyou = hyojunSiyou;
    }

    public String getMakerRyaku() {
        return makerRyaku;
    }

    public void setMakerRyaku(String makerRyaku) {
        this.makerRyaku = makerRyaku;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getSunpou() {
        return sunpou;
    }

    public void setSunpou(String sunpou) {
        this.sunpou = sunpou;
    }

    public String getBikou() {
        return bikou;
    }

    public void setBikou(String bikou) {
        this.bikou = bikou;
    }

    public String getSuryo() {
        return suryo;
    }

    public void setSuryo(String suryo) {
        this.suryo = suryo;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getTrkDate() {
        return trkDate;
    }

    public void setTrkDate(String trkDate) {
        this.trkDate = trkDate;
    }

    public String getUpdDate() {
        return updDate;
    }

    public void setUpdDate(String updDate) {
        this.updDate = updDate;
    }

    public String getSizaiName() {
        return sizaiName;
    }

    public void setSizaiName(String sizaiName) {
        this.sizaiName = sizaiName;
    }

    public String getHinban() {
        return hinban;
    }

    public void setHinban(String hinban) {
        this.hinban = hinban;
    }

}
