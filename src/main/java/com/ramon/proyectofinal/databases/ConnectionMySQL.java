/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramon.proyectofinal.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author el_an
 */
public class ConnectionMySQL {
    
    	public Connection get_connection() {
		
		Connection connection=null;
		 try {
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproyect?serverTimezone=UTC","root","mamalala123");

		} catch (SQLException e) {
			System.out.println(e);
		}
		return connection;
		
	}
    
}
