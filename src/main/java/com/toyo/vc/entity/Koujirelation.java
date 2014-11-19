package com.toyo.vc.entity;

/**
 * Created by Lsr on 10/27/14.
 */
public class Koujirelation {

    public int id;
    public int koujiid;
    public int kikisysid;
    public int kikiid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKikisysid() {
        return kikisysid;
    }

    public void setKikisysid(int kikisysid) {
        this.kikisysid = kikisysid;
    }

    public int getKikiid() {
        return kikiid;
    }

    public void setKikiid(int kikiid) {
        this.kikiid = kikiid;
    }

    public int getKoujiid() {
        return koujiid;
    }

    public void setKoujiid(int koujiid) {
        this.koujiid = koujiid;
    }
}
