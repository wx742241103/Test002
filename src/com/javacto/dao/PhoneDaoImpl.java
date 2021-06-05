package com.javacto.dao;

import com.javacto.Utile.BaseDao;
import com.javacto.po.Phone;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * WX742241103
 */
public class PhoneDaoImpl implements PhoneDao {
    @Override
    public Phone login(String name,String psd) {
        Connection connection=BaseDao.getCollections();
        Phone phone=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select *from phone where p_type=?and price=?");
            preparedStatement.setObject(1,name);
            preparedStatement.setObject(2,psd);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                phone=new Phone();
                phone.setId(resultSet.getInt(1));
                phone.setType(resultSet.getString(2));
                phone.setPrice(resultSet.getString(3));
                phone.setName(resultSet.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return phone;
    }

    @Override
    public int add(Phone phone) {
        String str="insert into phone(id,p_type,price,P_name)values(?,?,?,?)";
        Object num[]={phone.getId(),phone.getType(),phone.getPrice(),phone.getName()};
        return BaseDao.MyQuery(str,num);
    }

    @Override
    public int delete(int id) {
        Phone phone=new Phone();
        String str="delete from phone where id=?";
        Object num[]={id};
        return BaseDao.MyQuery(str,num);

    }

    @Override
    public int update(Phone phone) {

        String str="update phone set P_name=? where id=?  ";
        Object num[]={phone.getName(),phone.getId()};

        return BaseDao.MyQuery(str,num);

    }

    @Override
    public Phone query(int id){
        Connection connection=BaseDao.getCollections();
        Phone phone=null;
        try {
           PreparedStatement preparedStatement=connection.prepareStatement("select *from phone where id=?");
           preparedStatement.setObject(1,id);
           ResultSet resultSet=preparedStatement.executeQuery();
           while (resultSet.next()){
            phone=new Phone();
               phone.setId(resultSet.getInt(1));
               phone.setType(resultSet.getString(2));
               phone.setPrice(resultSet.getString(3));
               phone.setName(resultSet.getString(4));
               System.out.println("ww");
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return phone;
    }


    @Override@Test
    public List<Phone> queryAll() {
        List <Phone>list=new ArrayList();
        Connection connection=BaseDao.getCollections();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select *from phone ");

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Phone phone1=new Phone();
                phone1.setId(resultSet.getInt(1));
                phone1.setType(resultSet.getString(2));
                phone1.setPrice(resultSet.getString(3));
                phone1.setName(resultSet.getString(4));
                list.add(phone1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}
