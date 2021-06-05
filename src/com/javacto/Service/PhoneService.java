package com.javacto.Service;

import com.javacto.po.Phone;

import java.util.List;

/**
 * WX742241103
 */
public interface PhoneService {
    public int add(Phone phone);
    public  int delete(int id) ;
    public int update(Phone phone);
    public Phone query(int id);
    public List<Phone> queryAll();
    public Phone login(String name,String psd);
}
