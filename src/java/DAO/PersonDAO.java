/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.DBConnect;
import entity.Account;
import entity.Bhyt;
import entity.Bill;
import entity.Disease;
import entity.Hospital;
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
    	public ArrayList<Person> searchPerson(String s){
		ArrayList<Person> kq = new ArrayList<Person>();
		String sql = "SELECT bhyt.idbh, person.* FROM bhyt,person"
				+ " WHERE bhyt.idperson = person.idperson AND person.name LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + s + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bhyt bhyt = new Bhyt();
				bhyt.setId(rs.getString("idbh"));
				
				Person pers = new Person();
				pers.setPerson_id(rs.getInt("idperson"));
				pers.setName(rs.getString("name"));
				pers.setPhoneNumber(rs.getString("phonenumber"));
				pers.setDob(rs.getDate("dob"));
				pers.setEmail(rs.getString("email"));
				pers.setCmt(rs.getString("cmt"));
				pers.setSothebaohiem(rs.getString("sothebaohiem"));
				pers.setMuabaohiem(rs.getInt("muabaohiem"));
				pers.setAddress(rs.getString("address"));
				pers.setBhyt(bhyt);
				kq.add(pers);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public ArrayList<Bill> getBill(int id){
		ArrayList<Bill> kq = new ArrayList<Bill>();
		String sql = "SELECT disease.name, disease.khoa, hospital.name, bill.*"
				+ " FROM hospital,bill,person,disease WHERE person.idperson = ?"
				+ " AND disease.idperson = person.idperson "
				+ "AND bill.iddisease = disease.iddisease "
				+ "AND  disease.idhospital = hospital.idhospital";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt("idbill"));
				bill.setDateOfDischarge(rs.getDate("dateofDischarge"));
				bill.setDateOfAdmission(rs.getDate("dateofadmission"));
				bill.setAmount(rs.getInt("amount"));
				
				Hospital hos = new Hospital();
				hos.setName(rs.getString("hospital.name"));
				bill.setHospital(hos);
				
				Disease dis = new Disease();
				dis.setName(rs.getString("name"));
				dis.setKhoa(rs.getString("khoa"));
				bill.setDisease(dis);
				
				kq.add(bill);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
}
