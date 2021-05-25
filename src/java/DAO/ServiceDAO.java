/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Service;
import entity.ServiceType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ServiceDAO extends connect.CauHinhDBConnect {
    //Connection conn = null;  // connect sql server

    PreparedStatement ps = null; // query from netbean to sql server
    ResultSet rs = null;

    public List<Service> getListService() {
        try {
            String query = "SELECT service.id, service.name, service.ratio,  servicetype.id AS typeId, servicetype.name FROM service INNER JOIN servicetype ON service.service_type = servicetype.id ;";
            //conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Service> list = new ArrayList<>();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                Float ratio = rs.getFloat(3);
                ServiceType svType = new ServiceType(rs.getString(4), rs.getString(5));

                Service service = new Service(id, name, ratio, svType);
                list.add(service);
                //rs.deleteRow();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public Service getServiceById(String id) {
        try {
            String query = "SELECT service.id, service.name, service.ratio,  servicetype.id AS typeId, servicetype.name FROM service INNER JOIN servicetype ON service.service_type = servicetype.id WHERE service.id = ?;";
            //conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            Service sv = new Service();
            while (rs.next()) {
                ServiceType svType = new ServiceType(rs.getString(4), rs.getString(5));

//                sv = new Service(ma, name, ratio, svType);
                sv.setId(rs.getString(1));
                sv.setName(rs.getString(2));
                sv.setRatio(rs.getFloat(3));
                sv.setServiceType(svType);
                //rs.deleteRow();
            }
            
            return sv;
        } catch (SQLException e) {
        }

        return null;
    }

    public boolean changeServiceRatioById(String id, Float ratio) {
        if (ratio < 0 || ratio > 1 ) {
            return false;
        }

        try {
            String query = "UPDATE service SET ratio = ? WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setFloat(1, ratio);
            ps.setString(2, id);
            int updateCount = ps.executeUpdate();

            if (updateCount > 0) {
                return true;
            }

        } catch (SQLException e) {
        }
        return false;
    }

    public boolean deleteServiceById(String id) {
        try {
            String query = "DELETE FROM service WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);

            int deleteCount = ps.executeUpdate();

            if (deleteCount > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean addService(Service sv) {
        try {
            String query = "INSERT INTO service VALUES (?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(1, sv.getId());
            ps.setString(2, sv.getName());
            ps.setString(3, sv.getServiceType().getId());
            ps.setFloat(4, sv.getRatio());

            int addCount = ps.executeUpdate();

            if (addCount > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
