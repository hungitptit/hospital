/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Account;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author HUNG
 */
public class AccountDAOTest {
    
    public AccountDAOTest() {
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
     * Test of getListAccount method, of class AccountDAO.
     */
    @Test
    public void testGetListAccount() {
        System.out.println("getListAccount");
        AccountDAO instance = new AccountDAO();
        List<Account> expResult = Arrays.asList(new Account("hungitptit","manutd1998"),
                                                new Account("huynghiem1999","123456"),
                                                new Account("hungng132","124bdsa"),
                                                new Account("ngoduchung2931","1283ojlsd"));
        List<Account> result = instance.getListAccount();
        	//assertArrayEquals(expResult.toArray(),result.toArray());
        assertTrue(expResult.equals(result));
        //assertEquals(expResult.get(0).getUserName(), result.get(0).getUserName());
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
