package com.toyo.vc.dto;

import com.toyo.vc.entity.Kenan;
import com.toyo.vc.entity.Kiki;
import com.toyo.vc.entity.Kouji;
import com.toyo.vc.entity.Valve;

/**
 * Created by Lsr on 12/4/14.
 */
public class KenanForm extends Kenan {
    public Kouji kouji;
    public Valve valve;
    public Kiki kiki;

    public Kouji getKouji() {
        return kouji;
    }

    public void setKouji(Kouji kouji) {
        this.kouji = kouji;
    }

    public Valve getValve() {
        return valve;
    }

    public void setValve(Valve valve) {
        this.valve = valve;
    }

    public Kiki getKiki() {
        return kiki;
    }

    public void setKiki(Kiki kiki) {
        this.kiki = kiki;
    }
}
