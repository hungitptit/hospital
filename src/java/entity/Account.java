/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Account {
    private String username;
    private String password;
    
    public Account(){
        
    }
    
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public String getUserName() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
}
