/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Hospital {
    private int hospital_id;
    private String name;
    private String address;
    private int isNetwork;
    private List<Disease> listDisease;
    public Hospital() {
    }

    public Hospital(int hospital_id, String name, String address, int isNetwork) {
        this.hospital_id = hospital_id;
        this.name = name;
        this.address = address;
        this.isNetwork = isNetwork;
        this.listDisease = new ArrayList<Disease>();
    }

    public List<Disease> getListDisease() {
        return listDisease;
    }

    public void setListDisease(List<Disease> listDisease) {
        this.listDisease = listDisease;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsNetwork() {
        return isNetwork;
    }

    public void setIsNetwork(int isNetwork) {
        this.isNetwork = isNetwork;
    }
    
}
