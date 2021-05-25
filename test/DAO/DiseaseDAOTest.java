/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Disease;
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
public class DiseaseDAOTest {
    
    public DiseaseDAOTest() {
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
     * Test of getListDisease method, of class DiseaseDAO.
     */
    @Test
    public void testGetListDisease() {
        System.out.println("getListDisease");
        DiseaseDAO instance = new DiseaseDAO();
        List<Disease> expResult = Arrays.asList(new Disease(5, 4, 1, "Vẩy nến","Da liễu"),
                new Disease(6, 5, 1, "Nhồi máu cơ tim","Tim mạch"),
                new Disease(7, 6, 6, "Gãy tay","Chấn thương chỉnh hình"),
                new Disease(8, 7, 3, "Động kinh","Thần Kinh")
                );
        List<Disease> result = instance.getListDisease();
         assertTrue(expResult.equals(result));
        System.out.println("");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchByName method, of class DiseaseDAO.
     */
    @Test
    public void testSearchByName() {
        System.out.println("searchByName");
        String name = "Vay";
        DiseaseDAO instance = new DiseaseDAO();
        List<Disease> expResult = Arrays.asList(new Disease(5, 4, 1, "Vẩy nến","Da liễu" ));
        List<Disease> result = instance.searchByName(name);
        assertTrue(expResult.equals(result));
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
