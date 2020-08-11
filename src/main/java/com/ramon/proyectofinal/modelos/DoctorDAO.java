/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramon.proyectofinal.modelos;

import com.ramon.proyectofinal.databases.ConnectionMySQL;
import com.ramon.proyectofinal.utilidades.DoctorWindows;
import avisos.alert;
import java.sql.*;

/**
 *
 * @author el_an
 */
public class DoctorDAO {
	
	public static int doctorOnline;
	public static String doctorName;

        public static ConnectionMySQL connection=new ConnectionMySQL();
	public static PreparedStatement p=null;

	public static void crearDoctorDB(Doctor datos) {		
		
		try {Connection c=connection.get_connection();
			try {
				String query="INSERT INTO doctor (user,password,name,lastName,age,sex,especiality) VALUES (?,?,?,?,?,?,?)";
				p=c.prepareStatement(query);
				p.setString(1,datos.getUser());
				p.setString(2, datos.getPassword());
				p.setString(3, datos.getName());
				p.setString(4, datos.getLastName());
				p.setInt(5, datos.getAge());
				p.setString(6, datos.getSex());
				p.setString(7, datos.getEspeciality());
				p.executeUpdate();
                                
						
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
    public static void comprobarDoctorDB(String user,String password){

		try {Connection c=connection.get_connection();
			try {

				String query="SELECT * from doctor WHERE user=? and password=?";
				p=c.prepareStatement(query);
				p.setString(1, user);
				p.setString(2, password);

				ResultSet rs =p.executeQuery();
				if (!rs.next()){
					new alert("dataError").setVisible(true);

				}
				else{
					
					doctorOnline=rs.getInt("doctor_id");
					doctorName=rs.getString("name");
					//Here
					new DoctorWindows().setVisible(true);

				}

			} catch (SQLException e) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
    
}
