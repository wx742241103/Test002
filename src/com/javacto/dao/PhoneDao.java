package com.javacto.dao;

import com.javacto.po.Phone;

import java.util.List;

/**
 * WX742241103
 */
public interface PhoneDao {
    public Phone login(String name,String psd);
    public int add(Phone phone);
    public  int delete(int id) ;
    public int update(Phone phone);
    public Phone query(int id);
    public List<Phone> queryAll();


}
