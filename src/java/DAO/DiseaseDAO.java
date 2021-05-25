/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import connect.DBConnect;
import entity.Disease;
import entity.Disease;
import entity.Disease;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class DiseaseDAO extends connect.DBConnect{
    //Connection conn = null;  // connect sql server
    PreparedStatement ps = null; // query from netbean to sql server
    ResultSet rs = null;
    public List<Disease> getListDisease(){

        try {
            String query = "select * from disease";
            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Disease> list = new ArrayList<>();
            while(rs.next()) {
                Disease disease = new Disease(rs.getInt(1),rs.getInt(3),rs.getInt(2),rs.getString(4),rs.getString(5));
                list.add(disease);
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    }  
    public List<Disease> searchByName(String name){
        try {
            String query = "select * from disease where disease.name like ?";
            //conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
           
            ps.setString(1,"%"+name+"%");
            rs = ps.executeQuery();
            List<Disease> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt(1);
                int person_id = rs.getInt(3);
                int hospital_id = rs.getInt(2);
                String diseaseName = rs.getString(4);
                String khoa = rs.getString(5);
                Disease disease = new Disease(id, person_id, hospital_id, diseaseName, khoa );
                list.add(disease);
                //rs.deleteRow();
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    } 
    
 }
