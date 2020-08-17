package com.tremor.bd;
import java.sql.Connection;
import java.sql.DriverManager;
public class conexion_base {
    private Connection conex;
    public conexion_base() {
        String server = "localhost";
        String base= "tremor";
        String user= "root";
        String pswd = "n0m3l0";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conex=DriverManager.getConnection("jdbc:mysql://"+server+"/"+base,user,pswd);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection getConex() {
        return conex;
    }
    
}