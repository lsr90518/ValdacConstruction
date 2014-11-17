package com.toyo.vc.entity;

/**
 * Created by zhangrui on 14/11/12.
 */
public class Location {
    public int id;
    public String kCodeL;
    public String kCodeM;
    public String kCodeS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getkCodeL() {
        return kCodeL;
    }

    public void setkCodeL(String kCodeL) {
        this.kCodeL = kCodeL;
    }

    public String getkCodeM() {
        return kCodeM;
    }

    public void setkCodeM(String kCodeM) {
        this.kCodeM = kCodeM;
    }

    public String getkCodeS() {
        return kCodeS;
    }

    public void setkCodeS(String kCodeS) {
        this.kCodeS = kCodeS;
    }

}
