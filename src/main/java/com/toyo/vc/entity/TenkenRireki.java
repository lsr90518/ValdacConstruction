package com.toyo.vc.entity;

/**
 * Created by zhangrui on 14/11/18.
 */
public class TenkenRireki {
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
    public String trkDate;
    public String updDate;

    public String toText(){
        String text =
                koujiId+" "+
                        koujirelationId+" "+
                        kikiId+" "+
                        tenkenDate+" "+
                        tenkenNendo+" "+
                        tenkennaiyo+" "+
                        tenkenkekka+" "+
                        kanryoFlg+" ";
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

    public String getTrkDate(){return  trkDate;}
    public void setTrkDate(String trkDate){this.trkDate=trkDate;}

    public String getUpdDate(){return  updDate;}
    public void setUpdDate(String updDate){this.updDate=updDate;}
}
