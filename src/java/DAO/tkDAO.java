/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static connect.DBConnect.conn;
import entity.tk;
import entity.tk;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class tkDAO extends connect.DBConnect{
        PreparedStatement ps = null; // query from netbean to sql server
        ResultSet rs = null;
        public List<tk> getDsMuaBaoHiem(int id, String mode){
        try {
            String condition="h.idhospital";
            if(mode.equalsIgnoreCase("hospital")){
                condition = "h.idhospital";
            }
            if(mode.equalsIgnoreCase("person")){
                condition = "p.idperson";
            }
            if(mode.equalsIgnoreCase("disease")){
                condition = "d.iddisease";
            }
            String query = "SELECT p.idperson, p.name,p.dob,p.cmt, p.sothebaohiem,p.address, d.khoa  \n" +
                            "FROM person as p\n" +
                            "\n" +
                            "JOIN disease as d on p.idperson = d.idperson and p.muabaohiem=1\n" +
                            "JOIN hospital as h on d.idhospital = h.idhospital\n" + 
                            "Where "+condition+"=?";
           // conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
           
            ps.setInt(1,id);
            rs = ps.executeQuery();
            List<tk> list = new ArrayList<>();
            while(rs.next()) {
                int person_id = rs.getInt(1);
                String name = rs.getString(2);
                
           
                Date dob = rs.getDate(3);
               
                String cmt = rs.getString(4);
                String sothebaohiem = rs.getString(5);
                String address = rs.getString(6);
                String khoa = rs.getString(7);
                
                tk thongke = new tk(person_id, name,  dob,  cmt, sothebaohiem,address, khoa);
                list.add(thongke);
                //rs.deleteRow();
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    } 
}
