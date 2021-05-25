package connect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
 
public class CauHinhDBConnect {
public static Connection conn;
     
    public CauHinhDBConnect(){
        if(conn == null){
            String dbUrl = "jdbc:mysql://203.171.21.65:3306/sqa_project?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.cj.jdbc.Driver";
 
            try {
                Class.forName(dbClass);
                conn = DriverManager.getConnection (dbUrl, "root", "Passw@rd123");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

