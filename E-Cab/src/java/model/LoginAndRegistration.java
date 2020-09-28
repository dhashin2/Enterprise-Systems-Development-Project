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
public class LoginAndRegistration {
    
    /*
    Returns true if user was registered. Returns false if username was already taken or if an error occured during registration
    */
    public boolean Register(String username,String password, Connection con) {
        String query = "select CustomerName from Customers where CustomerName=" + "Upper('"+ username + "')";
        DBBean db = new DBBean();
        ResultSet resultSet = db.doQuery(query, con);
        try {
            // if resultSet is empty add username and password to db and return true
            if (resultSet.next() == false) {
                query = "INSERT INTO Customers (CustomerName, Password) VALUES (Upper('" + username + "'), '" + password + "')";
                db.doQuery(query, con);
                return true;
            }
            // username is already taken. therefore return false
            else {
                return false;
            }
        }
        // return false in case of an SQL exception
        catch (SQLException s){
            return false;
            //s.printStackTrace();
        }
    }
    
    /*
    Returns true if credentials match. Return false if credentials do not match or if an error occured
    */
    public boolean Login(String username,String password, Connection con) {
        String query = "select CustomerName, Password from Customers where CustomerName=Upper('" + username + "')";
        DBBean db = new DBBean();
        ResultSet resultSet = db.doQuery(query, con);
        try {
            // if resultSet is not empty check if credentials match
            if (resultSet.next() != false) {
                if (username.equalsIgnoreCase(resultSet.getString(1)) && password.equals(resultSet.getString(2))) {
                    return true;
                }
            }
        }
        // return false in case of an SQL exception
        catch (SQLException s){
            return false;
            //s.printStackTrace();
        }
        return false;
    }
}
