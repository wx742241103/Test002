package com.javacto.Service;

import com.javacto.dao.PhoneDao;
import com.javacto.dao.PhoneDaoImpl;
import com.javacto.po.Phone;

import java.util.List;

/**
 * WX742241103
 */
public class PhoneServiceImpl implements PhoneService {
    PhoneDao phoneDao=new PhoneDaoImpl();
    @Override
    public int add(Phone phone) {
        phoneDao.add(phone);
        return 0;
    }

    @Override
    public int delete(int id) {
        phoneDao.delete(id);
        return 0;
    }

    @Override
    public int update(Phone phone) {
        phoneDao.update(phone);
        return 0;
    }

    @Override
    public Phone query(int id) {

        return phoneDao.query(id);
    }

    @Override
    public List<Phone> queryAll() {


        return  phoneDao.queryAll();
    }

    @Override
    public Phone login(String name, String psd) {
        return phoneDao.login(name,psd);
    }
}
