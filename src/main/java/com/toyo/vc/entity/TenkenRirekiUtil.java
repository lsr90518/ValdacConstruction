package com.toyo.vc.entity;


/**
 * Created by Lsr on 10/14/14.
 */
public class TenkenRirekiUtil extends Kiki {
    //tenkenkiki部分
    public int id;
    public int koujiId;
    public int koujirelationId;
    public String tenkenDate;
    public String tenkenNendo;
    public String tenkenRank;
    public String tenkennaiyo;
    public String tenkenkekka;
    public String kanryoFlg;

    private Valve valve;

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getKoujiId(){return koujiId;}
    public void setKoujiId(int koujiId){this.koujiId=koujiId;}

    public int getKoujirelationId(){return  koujirelationId;}
    public void setKoujirelationId(int koujirelationId){this.koujirelationId=koujirelationId;}

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


    public Valve getValve() {
        return valve;
    }

    public void setValve(Valve valve) {
        this.valve = valve;
    }
}
