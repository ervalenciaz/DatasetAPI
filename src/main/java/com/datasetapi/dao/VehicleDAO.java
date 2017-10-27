/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datasetapi.dao;

import com.datasetapi.connection.ConnectionHandler;
import com.datasetapi.dao.interfaces.IVehicleDAO;
import com.datasetapi.domain.Vehicle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erick.valencia.zuta
 */
public class VehicleDAO implements IVehicleDAO {

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        ConnectionHandler handler = new ConnectionHandler();
        Connection conn = null;
        Vehicle vehicle = null;
        ResultSet rs = null;
        
        try {
            conn = handler.getConnection();
            String sql = "SELECT * FROM VEHICLES";
            Statement statement = conn.createStatement();
            
            if(statement.execute(sql)) {
                rs = statement.getResultSet();
            }
            
            while(rs.next()) {
                vehicle = new Vehicle();

                vehicle.setId(rs.getLong("id"));
                vehicle.setBuying(rs.getString("buying"));
                vehicle.setDoors(rs.getString("doors"));
                vehicle.setPersons(rs.getString("persons"));
                vehicle.setLugBoot(rs.getString("lug_boot"));
                vehicle.setSafety(rs.getString("safety"));
                vehicle.setLicensePlate(rs.getString("licensePlate"));
                vehicle.setOwner(rs.getLong("owner"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setClassValue(rs.getString("class_value"));
                
                vehicles.add(vehicle);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        return vehicles;
    }
    
    @Override
    public Vehicle getVehicleByLicensePlate(String licensePlate) throws IllegalArgumentException {
        ConnectionHandler handler = new ConnectionHandler();
        Connection conn = null;
        Vehicle vehicle = null;
        ResultSet rs = null;
        
        if(licensePlate == null) {
            throw new IllegalArgumentException("LicensePlate is required!");
        }
        
        try {
            conn = handler.getConnection();
            String sql = "SELECT * FROM VEHICLES WHERE LICENSEPLATE = '" + licensePlate + "'";
            Statement statement = conn.createStatement();
            
            if(statement.execute(sql)) {
                rs = statement.getResultSet();
            }
            
            while(rs.next()) {
                vehicle = new Vehicle();

                vehicle.setId(rs.getLong("id"));
                vehicle.setBuying(rs.getString("buying"));
                vehicle.setDoors(rs.getString("doors"));
                vehicle.setPersons(rs.getString("persons"));
                vehicle.setLugBoot(rs.getString("lug_boot"));
                vehicle.setSafety(rs.getString("safety"));
                vehicle.setLicensePlate(rs.getString("licensePlate"));
                vehicle.setOwner(rs.getLong("owner"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setClassValue(rs.getString("class_value"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        return vehicle;
    }
    
}
