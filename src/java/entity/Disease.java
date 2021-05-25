/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

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

    public Disease(int disease_id, int person_id, int hospital_id, String name, String khoa) {
        this.disease_id = disease_id;
        this.person_id = person_id;
        this.hospital_id = hospital_id;
        this.name = name;
        this.khoa = khoa;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disease other = (Disease) obj;
        if (this.disease_id != other.disease_id) {
            return false;
        }
        if (this.person_id != other.person_id) {
            return false;
        }
        if (this.hospital_id != other.hospital_id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.khoa, other.khoa)) {
            return false;
        }
        return true;
    }
    
}
