/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.ServiceDAO;
import entity.Service;
import entity.ServiceType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ADMIN
 */
public class ServiceDAOJUnitTest {

    // Kiem thu don vi lay danh sach cau hinh
    @Test
    public void testGetListService() {
        ServiceDAO dao = new ServiceDAO();

        // Test case #1: Tim 
        List<Service> listService = dao.getListService();
        Assert.assertNotNull(listService);
        Assert.assertEquals(4, listService.size());
    }

    // Kiem thu don vi lay cau hinh theo id
    @Test
    public void testGetServiceById() {
        ServiceDAO dao = new ServiceDAO();

        // Test case #1: Tim khong ra du lieu
        Service sv = dao.getServiceById("10003");
        Assert.assertNull(sv.getId());

        // Test case #2: Tim ra du lieu
        sv = dao.getServiceById("10001");
        Assert.assertNotNull(sv.getId());

    }
    
    @Test
    public void testUpdateServiceById() throws SQLException{
        ServiceDAO dao = new ServiceDAO();
        Connection con = dao.conn;
        boolean res;
        try {
            con.setAutoCommit(false);

            // Test case #1:  0.0001
            res = dao.changeServiceRatioById("10001", Float.parseFloat("0.0001"));
            Assert.assertEquals(true,res);
            
            // Test case #2: 1
            res = dao.changeServiceRatioById("10001", Float.parseFloat("1"));
            Assert.assertEquals(true,res);
            
            // Test case #3: 0
            res = dao.changeServiceRatioById("10001", Float.parseFloat("0"));
            Assert.assertEquals(true,res);
            
            // Test case #4: 0.0009
            res = dao.changeServiceRatioById("10001", Float.parseFloat("0.0009"));
            Assert.assertEquals(true,res);
            
            // Test case #5: -0.0001
            res = dao.changeServiceRatioById("10001", Float.parseFloat("-0.0001"));
            Assert.assertEquals(false,res);
            
            // Test case #6: -1
            res = dao.changeServiceRatioById("10001", Float.parseFloat("-1"));
            Assert.assertEquals(false,res);
            
            // Test case #7: 1.0001
            res = dao.changeServiceRatioById("10001", Float.parseFloat("1.0001"));
            Assert.assertEquals(false,res);
            
            // Test case #8: 999999
             res = dao.changeServiceRatioById("10001", Float.parseFloat("99999"));
            Assert.assertEquals(false,res);
            
            // Test case #9: -0,999999999111
            res = dao.changeServiceRatioById("10001", Float.parseFloat("-0.999999999111"));
            Assert.assertEquals(false,res);
            
            // Test case #10: -90999999
            res = dao.changeServiceRatioById("10001", Float.parseFloat("-90999999"));
            Assert.assertEquals(false,res);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            con.rollback();
            con.setAutoCommit(true);
        }
        
    }
    
    @Test
    public void testDeleteServiceById() throws SQLException{
        ServiceDAO dao = new ServiceDAO();
        ServiceType type = new ServiceType("1000","Phẫu thuật - Mổ");
        Service sv = new Service("10005","Mổ mũi",Float.parseFloat("0.3"),type);
        Connection con = dao.conn;
        try {
            con.setAutoCommit(false);
            dao.addService(sv);
            dao.deleteServiceById(sv.getId());
            Assert.assertEquals(4,dao.getListService().size()); 
            
            Service nsv = dao.getServiceById(sv.getId());
            Assert.assertNull(nsv.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.rollback();
            con.setAutoCommit(true);
        }
    }

}
