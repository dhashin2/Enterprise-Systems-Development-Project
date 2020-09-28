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
public class Admin extends User{
    
    public Admin(String username, String password, Connection con) {
        super(username, password, con);
    }
    
}
