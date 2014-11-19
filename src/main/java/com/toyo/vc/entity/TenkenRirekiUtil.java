package com.toyo.vc.entity;


/**
 * Created by Lsr on 10/14/14.
 */
public class TenkenRirekiUtil {
    //tenkenkiki部分
    public int id;
    public int koujiId;
    public int koujirelationId;
    public int kikiId;
    public String tenkenDate;
    public String tenkenNendo;
    public String tenkenRank;
    public String tenkennaiyo;
    public String tenkenkekka;
    public String kanryoFlg;


//kiki基本情報部分
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


    public String toText(){
        String text =
                koujiId+" "+
                        koujirelationId+" "+
                        kikiId+" "+
                        tenkenDate+" "+
                        tenkenNendo+" "+
                        tenkennaiyo+" "+
                        tenkenkekka+" "+
                        kanryoFlg+" "+
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


    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getKoujiId(){return koujiId;}
    public void setKoujiId(int koujiId){this.koujiId=koujiId;}

    public int getKoujirelationId(){return  koujirelationId;}
    public void setKoujirelationId(int koujirelationId){this.koujirelationId=koujirelationId;}

    public int getKikiId(){return kikiId;}
    public void setKikiId(int kikiId){this.kikiId=kikiId;}

    public String getTenkenDate(){return tenkenDate;}
    public void setTenkenDate(String tenkenDate){this.tenkenDate=tenkenDate;}

    public String getTenkenNendo(){return tenkenNendo;}
    public void setTenkenNendo(String tenkenNendo){this.tenkenNendo=tenkenNendo;}

    public String getTenkenRank(){return  tenkenRank;}
    public void setTenkenRank(String tenkenRank){this.tenkenRank=tenkenRank;}

    public String getTenkennaiyo(){return  tenkennaiyo;}
    public void setTenkennaiyo(String tenkennaiyo){this.tenkennaiyo=tenkennaiyo;}

    public String getTenkenkekka(){return  tenkenkekka;}
    public void setTenkenkekka(String tenkenkekka){this.tenkenkekka=tenkenkekka;}

    public String getKanryoFlg(){return kanryoFlg;}
    public void setKanryoFlg(String kanryoFlg){this.kanryoFlg=kanryoFlg;}



    //機器基本情報部分
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
}
