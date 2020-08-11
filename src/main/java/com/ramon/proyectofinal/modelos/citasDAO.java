/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramon.proyectofinal.modelos;
import java.util.*;

import com.ramon.proyectofinal.databases.ConnectionMySQL;
import static com.ramon.proyectofinal.modelos.DoctorDAO.doctorOnline;
import avisos.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.ResultSet;


/**
 *
 * @author el_an
 */
public class citasDAO {
    
        public static ConnectionMySQL connection=new ConnectionMySQL();
		public static PreparedStatement p=null;

		public static String[] arrowData;

		public static List<Integer>comprobateIdCites = new ArrayList<Integer>();
    
    	public static void crearDoctorCitaDB(citas datos) {		
		
		try {Connection c=connection.get_connection();
			try {
				String query="INSERT INTO doctorcites "+
                                        "(date,time,whereis,id_doctor) "+
                                        "VALUES (?,?,?,?)";
				p=c.prepareStatement(query);
				p.setString(1,datos.getDate());
				p.setString(2, datos.getTime());
				p.setString(3, datos.getWhere());
				p.setInt(4, doctorOnline);
				p.executeUpdate();
                                
						
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	public static void listarDoctorCitasDB(javax.swing.table.DefaultTableModel modelo,String typeOperation){


		try {Connection c=connection.get_connection();
			ResultSet rs=null; 
			

			try {
				String query="SELECT*FROM doctorcites WHERE id_doctor="+doctorOnline;
				if (typeOperation=="patient"){
					query="SELECT*from doctorcites";	
				}
				p=c.prepareStatement(query);
				rs=p.executeQuery();					
				while (rs.next()) {
					if (typeOperation=="patient"){
						comprobateIdCites.add(rs.getInt("id_dc"));
					}
					String id=rs.getString("id_dc");
					String date=rs.getString("date");
					String time=rs.getString("time");
					String whereis=rs.getString("whereis");
					String idDoctor=rs.getString("id_doctor");
					String created=rs.getString("created");
					String modified=rs.getString("modified");
					
                    String[] datos={id,date,time,whereis,idDoctor,created,modified};

					modelo.addRow(datos);
				}
												
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public static void actualizarDoctorCitaDB(citas datos,int x){

		try {Connection c=connection.get_connection();
			try {

				String query="UPDATE doctorcites SET date=?,time=?,whereis=?,modified=CURRENT_TIMESTAMP "+
				"WHERE id_doctor=? and id_dc=? ";
				p=c.prepareStatement(query);
				p.setString(1, datos.getDate());
				p.setString(2, datos.getTime());
				p.setString(3, datos.getWhere());
				p.setInt(4, doctorOnline);
				p.setInt(5, x);
				p.executeUpdate();
				int count=p.executeUpdate();


				if (count==0){
					new alert("dataError").setVisible(true);

				}
				else{
					new success("").setVisible(true);
				}

			} catch (SQLException e) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void borrarDoctorCitaDB(int x){

		try {Connection c=connection.get_connection();
			try {

				String query="DELETE FROM doctorcites WHERE id_doctor=? and id_dc=?";
				p=c.prepareStatement(query);
				p.setInt(1,doctorOnline);
				p.setInt(2,x);
				p.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
    
    
}
