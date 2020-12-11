package com.velasteguicorps.coopmovil.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */
public class DBConnection {
    private static Connection cnn;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="CoopMovil";
    private static final String pass="CoopMovil";
    private static final String url="jdbc:mysql://localhost:3306/CoopMovil?autoReconnect=true&useSSL=false";
    private static DBConnection cbd;
    
    
    private DBConnection(){
        try{
            Class.forName(driver);
            cnn=DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: "+ex);
        }
    }
    
    
    public static DBConnection getInstance(){
        if(cbd == null)
            cbd = new DBConnection();
        return cbd;
    }
    
    public Connection getConnection(){
        return cnn;
    }
    
    public void getClose() {
        try{
            cnn.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ex);
        }
    }
}
