/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class Disease {
    private int disease_id;
    private int person_id;
    private int hospital_id;
    private String name;
    private String khoa;

    public Disease() {
    }

    public Disease(int disease_id, int person_id, int hospital_id, String name) {
        this.disease_id = disease_id;
        this.person_id = person_id;
        this.hospital_id = hospital_id;
        this.name = name;
    }

    public int getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(int disease_id) {
        this.disease_id = disease_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
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
    
}
