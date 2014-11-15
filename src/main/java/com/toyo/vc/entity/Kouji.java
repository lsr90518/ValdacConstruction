package com.toyo.vc.entity;

/**
 * Created by zhangrui on 14/11/14.
 */
public class Kouji {

    public int id;
    public String kjNo;
    public String kjMeisyo;
    public String kjKbn;
    public String bgnYmd;
    public String endYmd;
    public String nextYmd;
    public String nendo;
    public String syukan;
    public String gyosyaRyakuA;
    public String location;
    public String status;
    public String responsibility;
    public String trkDate;
    public String updDate;


    public String toText(){
        String text =
                kjNo+" "+
                kjMeisyo+" "+
                kjKbn+" "+
                bgnYmd+" "+
                endYmd+" "+
                nextYmd+" "+
                nendo+" "+
                syukan+" "+
                gyosyaRyakuA+" "+
                location+" "+
                responsibility+" ";
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

    public int getId(){return  id;}

    public void setId(int id){this.id=id;}

    public String getKjNo(){return  kjNo;}

    public void setKjNo(String kjNo){this.kjNo=kjNo;}

    public String getKjMeisyo(){return  kjMeisyo;}

    public void setKjMeisyo(String kjMeisyo){this.kjMeisyo=kjMeisyo;}

    public String getKjKbn(){return  kjKbn;}

    public void setKjKbn(String kjkbn){this.kjKbn=kjkbn;}

    public String getBgnYmd(){return  bgnYmd;}

    public void setBgnYmd(String bgnYmd){this.bgnYmd=bgnYmd;}

    public String getEndYmd(){return  endYmd;}

    public void setEndYmd(String endYmd){this.endYmd=endYmd;}

    public String getNextYmd(){return  nextYmd;}

    public void setNextYmd(String nextYmd){this.nextYmd=nextYmd;}

    public String getNendo(){return  nendo;}

    public void setNendo(String nendo){this.nendo=nendo;}

    public String getSyukan(){return  syukan;}

    public void setSyukan(String syukan){this.syukan=syukan;}

    public String getGyosyaRyakuA(){return gyosyaRyakuA;}

    public void setGyosyaRyakuA(String gyosyaRyakuA){this.gyosyaRyakuA=gyosyaRyakuA;}

    public String getLocation(){return location;}

    public void setLocation(String location){this.location=location;}

    public String getStatus(){return status;}

    public void setStatus(String status){this.status=status;}

    public String getResponsibility(){return  responsibility;}

    public void setResponsiblity(String responsibility){this.responsibility=responsibility;}

    public String getTrkDate(){return trkDate;}

    public void setTrkDate(String trkDate){this.trkDate=trkDate;}

    public String getUpdDate(){return  updDate;}

    public void setUpdDate(String updDate){this.updDate=updDate;}

}
