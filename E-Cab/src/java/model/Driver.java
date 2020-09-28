/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class Driver extends User{
    
    String VehicleNo;

    public Driver(String VehicleNo, String username, String password, Connection con) {
        super(username, password, con);
        this.VehicleNo = VehicleNo;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(String VehicleNo) {
        this.VehicleNo = VehicleNo;
    }
    
}