package com.toyo.vc.entity;

/**
 * Created by Lsr on 10/14/14.
 */
public class Valve {
    public int kikiSysId;
    public String locationName;
    public String kCode;
    public String kikiSysSeq;
    public String vNo;
    public String vNoSub;
    public String benMeisyo;
    public String keisikiRyaku;
    public String keisiki;
    public String sousaRyaku;
    public String sousa;
    public String classRyaku;
    public String classType;
    public String yobikeiRyaku;
    public String yobikei;
    public String szHouRyaku;
    public String szHou;
    public String szKikaku;
    public String zaisituRyaku;
    public String zaisitu;
    public String aturyokuMax;
    public String tani;
    public String ondoMax;
    public String ryutaiRyaku;
    public String ryutai;
    public String ics;
    public String futai;
    public String trkDate;
    public String updDate;

    public String toText(){
        String text =
                    vNo+" "+
                    vNoSub+" "+
                    locationName+" "+
                    benMeisyo+" "+
                    keisikiRyaku+" "+
                    keisiki+" "+
                    sousaRyaku+" "+
                    sousa+" "+
                    classRyaku+" "+
                    classType+" "+
                    yobikeiRyaku+" "+
                    yobikei+" "+
                    szHouRyaku+" "+
                    szHou+" "+
                    szKikaku+" "+
                    zaisituRyaku+" "+
                    zaisitu+" "+
                    aturyokuMax+" "+
                    tani+" "+
                    ondoMax+" "+
                    ryutaiRyaku+" "+
                    ryutai+" "+
                    ics+" "+
                    futai+" ";
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

    public int getKikiSysId() {
        return kikiSysId;
    }

    public void setKikiSysId(int kikiSysId) {
        this.kikiSysId = kikiSysId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getkCode() {
        return kCode;
    }

    public void setkCode(String kCode) {
        this.kCode = kCode;
    }

    public String getKikiSysSeq() {
        return kikiSysSeq;
    }

    public void setKikiSysSeq(String kikiSysSeq) {
        this.kikiSysSeq = kikiSysSeq;
    }

    public String getvNo() {
        return vNo;
    }

    public void setvNo(String vNo) {
        this.vNo = vNo;
    }

    public String getvNoSub() {
        return vNoSub;
    }

    public void setvNoSub(String vNoSub) {
        this.vNoSub = vNoSub;
    }

    public String getBenMeisyo() {
        return benMeisyo;
    }

    public void setBenMeisyo(String benMeisyo) {
        this.benMeisyo = benMeisyo;
    }

    public String getKeisikiRyaku() {
        return keisikiRyaku;
    }

    public void setKeisikiRyaku(String keisikiRyaku) {
        this.keisikiRyaku = keisikiRyaku;
    }

    public String getKeisiki() {
        return keisiki;
    }

    public void setKeisiki(String keisiki) {
        this.keisiki = keisiki;
    }

    public String getSousaRyaku() {
        return sousaRyaku;
    }

    public void setSousaRyaku(String sousaRyaku) {
        this.sousaRyaku = sousaRyaku;
    }

    public String getSousa() {
        return sousa;
    }

    public void setSousa(String sousa) {
        this.sousa = sousa;
    }

    public String getClassRyaku() {
        return classRyaku;
    }

    public void setClassRyaku(String classRyaku) {
        this.classRyaku = classRyaku;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getYobikeiRyaku() {
        return yobikeiRyaku;
    }

    public void setYobikeiRyaku(String yobikeiRyaku) {
        this.yobikeiRyaku = yobikeiRyaku;
    }

    public String getYobikei() {
        return yobikei;
    }

    public void setYobikei(String yobikei) {
        this.yobikei = yobikei;
    }

    public String getSzHouRyaku() {
        return szHouRyaku;
    }

    public void setSzHouRyaku(String szHouRyaku) {
        this.szHouRyaku = szHouRyaku;
    }

    public String getSzHou() {
        return szHou;
    }

    public void setSzHou(String szHou) {
        this.szHou = szHou;
    }

    public String getSzKikaku() {
        return szKikaku;
    }

    public void setSzKikaku(String szKikaku) {
        this.szKikaku = szKikaku;
    }

    public String getZaisituRyaku() {
        return zaisituRyaku;
    }

    public void setZaisituRyaku(String zaisituRyaku) {
        this.zaisituRyaku = zaisituRyaku;
    }

    public String getZaisitu() {
        return zaisitu;
    }

    public void setZaisitu(String zaisitu) {
        this.zaisitu = zaisitu;
    }

    public String getAturyokuMax() {
        return aturyokuMax;
    }

    public void setAturyokuMax(String aturyokuMax) {
        this.aturyokuMax = aturyokuMax;
    }

    public String getTani() {
        return tani;
    }

    public void setTani(String tani) {
        this.tani = tani;
    }

    public String getOndoMax() {
        return ondoMax;
    }

    public void setOndoMax(String ondoMax) {
        this.ondoMax = ondoMax;
    }

    public String getRyutaiRyaku() {
        return ryutaiRyaku;
    }

    public void setRyutaiRyaku(String ryutaiRyaku) {
        this.ryutaiRyaku = ryutaiRyaku;
    }

    public String getRyutai() {
        return ryutai;
    }

    public void setRyutai(String ryutai) {
        this.ryutai = ryutai;
    }

    public String getIcs() {
        return ics;
    }

    public void setIcs(String ics) {
        this.ics = ics;
    }

    public String getFutai() {
        return futai;
    }

    public void setFutai(String futai) {
        this.futai = futai;
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
