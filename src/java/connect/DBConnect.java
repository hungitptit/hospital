package connect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnect {
public static Connection conn;
     
    public DBConnect(){
        if(conn == null){
            String dbUrl = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.cj.jdbc.Driver";
 
            try {
                Class.forName(dbClass);
                conn = DriverManager.getConnection (dbUrl, "root", "manutd1998");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

