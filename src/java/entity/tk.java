/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class tk {
    private int idPerson;
    private String name;
    private Date dob;
    private String cmt;
    private String sothe;
    private String address;
    private String khoa;

    public tk() {
    }

    public tk(int idPerson, String name, Date dob, String cmt, String sothe, String address, String khoa) {
        this.idPerson = idPerson;
        this.name = name;
        this.dob = dob;
        this.cmt = cmt;
        this.sothe = sothe;
        this.address = address;
        this.khoa = khoa;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getSothe() {
        return sothe;
    }

    public void setSothe(String sothe) {
        this.sothe = sothe;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    
}
