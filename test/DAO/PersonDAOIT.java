/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Person;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
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
public class PersonDAOIT {
    
    public PersonDAOIT() {
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
     * Test of getListPerson method, of class PersonDAO.
     */
    @Test
    public void testGetListPerson() {
        System.out.println("getListPerson");
        PersonDAO instance = new PersonDAO();
        List<Person> expResult = Arrays.asList(
                new Person(4, "Trần Xuân Hưng", 1, "0911060297", Date.valueOf("1998-12-27"), "xuanhungtran2712@gmail.con", "03837348462143214", "11926492834", "Hà Nội"),
                new Person(5, "Nghiêm Quang Huy", 2, "0923462472", Date.valueOf("1999-01-03"), "nghiemhuy1999@gmail.com", "990324812731221", "", "Hà Nội"),
                new Person(6, "Ngô Đức Hùng", 3, "0921376321", Date.valueOf("1999-03-02"), "ngohung219@gmail.com", "09012397312321", "8970094223412", "Hà Nội"),
                new Person(7, "Nguyễn Quốc Hùng", 4, "0923682341", Date.valueOf("1998-09-08"), "hgna@gmail.com", "03837348462143214", null, "Hà Nội"));
        List<Person> result = instance.getListPerson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByName method, of class PersonDAO.
     */
    @Test
    public void testSearchByName() {
        System.out.println("searchByName");
        String name = "hung";
        PersonDAO instance = new PersonDAO();
        List<Person> expResult = Arrays.asList(new Person(4, "Trần Xuân Hưng", 1, "0911060297", Date.valueOf("1998-12-27"), "xuanhungtran2712@gmail.con", "03837348462143214", "11926492834", "Hà Nội"));
        List<Person> result = instance.searchByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
