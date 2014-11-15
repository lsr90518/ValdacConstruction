package com.toyo.vc.dao;

import com.toyo.vc.entity.Kouji;

import java.util.List;

/**
 * Created by zhangrui on 14/11/14.
 */
public interface KoujiMapper {

    public List<Kouji> findByUserId(String userid);

    public List<Kouji> findLastedTenKoujiByResponsibility(String userid);

    public List<Kouji> findUpdateTenKoujiByResponsibility(String userid);

    public void insertKouji(Kouji kouji);

    public int getLastInsertId();
}
