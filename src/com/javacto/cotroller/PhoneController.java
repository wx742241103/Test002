package com.javacto.cotroller;

import com.javacto.Service.PhoneService;
import com.javacto.Service.PhoneServiceImpl;
import com.javacto.po.Phone;
import org.junit.Test;

import java.util.List;


/**
 * WX742241103
 */

public class PhoneController {
    PhoneService phoneService=new PhoneServiceImpl();

    @Test
    public void  add(){
        Phone phone=new Phone();
        phone.setId(5);
        phone.setType("大1米");
        phone.setPrice("4444");
        phone.setName("余紫欣23");
        phoneService.add(phone);
    }
    @Test
    public void  delete(){
        phoneService.delete(5);

    }
    @Test
    public  void update(){
Phone phone=new Phone();
phone.setId(5);
        phone.setName("你");
        phoneService.update(phone);



    }
    @Test
    public void  query(){
       Phone phone1= phoneService.query(1);
        System.out.println(phone1);

    }
    @Test
    public void  queryAll(){
 List<Phone> list=phoneService.queryAll();
 for (Phone o:list){
     System.out.println(o);
 }
    }
    @Test
    public void login(){
       Phone phone= phoneService.login("小米","5000");
        System.out.println(phone);
    }
}
