/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.DBConnect;
import entity.Account;
import entity.Hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class HospitalDAO extends connect.DBConnect{
    //Connection conn = null;  // connect sql server
    PreparedStatement ps = null; // query from netbean to sql server
    ResultSet rs = null;
    
    public List<Hospital> getListHospital(){
        try {
            String query = "select * from hospital";
           // conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Hospital> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt(1);
                String hospitalName = rs.getString(2);
                String address = rs.getString(3);
                int isNetwork = rs.getInt(4);
                Hospital hospital = new Hospital(id,hospitalName,address,isNetwork);
                list.add(hospital);
                //rs.deleteRow();
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    }  
    public List<Hospital> searchByName(String name){
        try {
            String query = "select * from hospital where hospital.name like ?";
           // conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
           
            ps.setString(1,"%"+name+"%");
            rs = ps.executeQuery();
            List<Hospital> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt(1);
                String hospitalName = rs.getString(2);
                String address = rs.getString(3);
                int isNetwork = rs.getInt(4);
                Hospital hospital = new Hospital(id,hospitalName,address,isNetwork);
                list.add(hospital);
                //rs.deleteRow();
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    } 
}
