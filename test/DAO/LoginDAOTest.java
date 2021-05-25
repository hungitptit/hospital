/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HUNG
 */
public class LoginDAOTest {
    
    public LoginDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkLogin method, of class LoginDAO.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String user = "hungitptit";
        String pass = "manutd1998";
        LoginDAO instance = new LoginDAO();
        Account expResult = new Account("1", "hungitptit");
        Account result = instance.checkLogin(user, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
