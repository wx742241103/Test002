package com.javacto.Utile;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * WX742241103
 */
public class BaseDao {

    public static Connection getCollections(){
        Properties properties=new Properties();
        String path="db.properties";

        InputStream inputStream=BaseDao.class.getClassLoader().getResourceAsStream(path);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
       String name=properties.getProperty("db.name");
       String url=properties.getProperty("db.url");
       String root=properties.getProperty("db.root");
       String pwd=properties.getProperty("db.pwd");
        Connection conn = null;
        try {
            Class.forName(name);

            conn= DriverManager.getConnection(url,root,pwd);

        }catch (Exception e){
            e.printStackTrace();
        }
        return  conn;
    }

    public  static int MyQuery(String str,Object num[]){
        Connection connection=BaseDao.getCollections();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=  connection.prepareStatement(str);
            for (int i=0;i<num.length;i++){
                preparedStatement.setObject(i+1,num[i]);

            }
            int num1 = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
