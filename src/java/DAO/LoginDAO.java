/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.DBConnect;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoginDAO extends connect.DBConnect{
   // Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Account checkLogin(String user, String pass){
        try {
            String query = "select * from account where username =? and password=?";
            //conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                Account a = new Account(rs.getString(1),rs.getString(2));
                return a;
            }
            
        } catch (Exception e) {
            
        }
        return null;
    }
}
