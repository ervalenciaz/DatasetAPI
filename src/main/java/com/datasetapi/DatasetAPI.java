/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datasetapi;

import com.datasetapi.dao.VehicleDAO;
import com.datasetapi.domain.Vehicle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author erick.valencia.zuta
 */
@CrossOrigin
@RestController
@RequestMapping("/datasetapi/vehicle")
public class DatasetAPI {
    
    private VehicleDAO vehicleDao;
    
    @RequestMapping(value = "/{licensePlate}", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> getVehicleByLicensePlate(@PathVariable("licensePlate") String licensePlate) {
        System.out.println("RECIBE EL REQUEST!");
        vehicleDao = new VehicleDAO();
        Vehicle vehicle = vehicleDao.getVehicleByLicensePlate(licensePlate);
        
        if(vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
