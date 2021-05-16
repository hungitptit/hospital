/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.DBConnect;
import entity.Account;
import entity.Disease;
import entity.Person;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class PersonDAO extends connect.DBConnect{
    //Connection conn = null;  // connect sql server
    PreparedStatement ps = null; // query from netbean to sql server
    ResultSet rs = null;
    
    public List<Person> getListPerson(){
        try {
            String query = "select * from person";
            //conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Person> list = new ArrayList<>();
            while(rs.next()) {
                int person_id = rs.getInt(1);
                String name = rs.getString(2);
                String phoneNumber = rs.getString(3);
                Date dob = rs.getDate(4);
                String email = rs.getString(5);
                String cmt = rs.getString(6);
                String sothebaohiem = rs.getString(7);
                String address = rs.getString(8);
                int account_id = rs.getInt(10);
                
                Person person = new Person(person_id, name, account_id, phoneNumber, dob, email, cmt, sothebaohiem,address);
                list.add(person);
                //rs.deleteRow();
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    }  
    public List<Person> searchByName(String name){
        try {
            String query = "select * from person where person.name like ?";
           // conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
           
            ps.setString(1,"%"+name+"%");
            rs = ps.executeQuery();
            List<Person> list = new ArrayList<>();
            while(rs.next()) {
                int person_id = rs.getInt(1);
                String personName = rs.getString(2);
                
                String phoneNumber = rs.getString(3);
                Date dob = rs.getDate(4);
                String email = rs.getString(5);
                String cmt = rs.getString(6);
                String sothebaohiem = rs.getString(7);
                String address = rs.getString(8);
                int account_id = rs.getInt(10);
                
                Person person = new Person(person_id, personName , account_id, phoneNumber, dob, email, cmt, sothebaohiem,address);
                list.add(person);
                //rs.deleteRow();
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    } 
}
