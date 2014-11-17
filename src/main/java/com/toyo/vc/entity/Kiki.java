package com.toyo.vc.entity;

/**
 * Created by Lsr on 10/15/14.
 */
public class Kiki {

    public int kikiId;
    public String kikiBunrui;
    public String kikiBunruiSeq;
    public String kikiNo;
    public String kikiMei;
    public String syukan;
    public String makerRyaku;
    public String maker;
    public String katasikiNo;
    public String serialNo;
    public String orderNo;
    public String bikou;
    public String imageId;
    public String trkDate;
    public String updDate;

    public String toText(){
        String text =
                    kikiBunrui+" "+
                    kikiNo+" "+
                    kikiMei+" "+
                    syukan+" "+
                    makerRyaku+" "+
                    maker+" "+
                    katasikiNo+" "+
                    serialNo+" "+
                    orderNo+" "+
                    bikou;
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

    public int getKikiId() {
        return kikiId;
    }

    public void setKikiId(int kikiId) {
        this.kikiId = kikiId;
    }

    public String getKikiBunrui() {
        return kikiBunrui;
    }

    public void setKikiBunrui(String kikiBunrui) {
        this.kikiBunrui = kikiBunrui;
    }

    public String getKikiBunruiSeq() {
        return kikiBunruiSeq;
    }

    public void setKikiBunruiSeq(String kikiBunruiSeq) {
        this.kikiBunruiSeq = kikiBunruiSeq;
    }

    public String getKikiNo() {
        return kikiNo;
    }

    public void setKikiNo(String kikiNo) {
        this.kikiNo = kikiNo;
    }

    public String getKikiMei() {
        return kikiMei;
    }

    public void setKikiMei(String kikiMei) {
        this.kikiMei = kikiMei;
    }

    public String getSyukan() {
        return syukan;
    }

    public void setSyukan(String syukan) {
        this.syukan = syukan;
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

    public String getKatasikiNo() {
        return katasikiNo;
    }

    public void setKatasikiNo(String katasikiNo) {
        this.katasikiNo = katasikiNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBikou() {
        return bikou;
    }

    public void setBikou(String bikou) {
        this.bikou = bikou;
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
}
