/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
}
