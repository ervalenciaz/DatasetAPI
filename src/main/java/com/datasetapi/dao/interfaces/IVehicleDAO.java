/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datasetapi.dao.interfaces;

import com.datasetapi.domain.Vehicle;
import java.util.List;

/**
 *
 * @author erick.valencia.zuta
 */
public interface IVehicleDAO {
    
    public List<Vehicle> getAllVehicles();
    public Vehicle getVehicleByLicensePlate(String licensePlate) throws IllegalArgumentException;
    
}
