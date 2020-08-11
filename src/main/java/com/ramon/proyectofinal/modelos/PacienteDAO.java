/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramon.proyectofinal.modelos;

import com.ramon.proyectofinal.databases.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author el_an
 */
public class PacienteDAO {

    public static ConnectionMySQL connection=new ConnectionMySQL();
	public static PreparedStatement p=null;

	public static void crearPacienteDB(Paciente datos,int x) {		
		
		try {Connection c=connection.get_connection();
			try {
				String query="INSERT INTO patient (name,lastName,age,status,problem,id_doctor) VALUES (?,?,?,?,?,?)";
				p=c.prepareStatement(query);
				p.setString(1,datos.getName());
				p.setString(2, datos.getLastName());
				p.setInt(3, datos.getAge());
				p.setString(4, datos.getStatus());
				p.setString(5, datos.getProblem());
				p.setInt(6,x);
				p.executeUpdate();
                                
						
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	public static void crearPacienteUrgenteDB(Paciente datos) {		
		
		try {Connection c=connection.get_connection();
			try {
				String query="INSERT INTO urgent (name,lastName,age,status,problem) VALUES (?,?,?,?,?)";
				p=c.prepareStatement(query);
				p.setString(1,datos.getName());
				p.setString(2, datos.getLastName());
				p.setInt(3, datos.getAge());
				p.setString(4, datos.getStatus());
				p.setString(5, datos.getProblem());
				p.executeUpdate();
                                
						
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	public static void borrarCitaDB(int x){

		try {Connection c=connection.get_connection();
			try {

				String query="DELETE FROM patient WHERE patient_id=?";
				p=c.prepareStatement(query);
				p.setInt(1,x);
				p.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void listarCitasDB(javax.swing.table.DefaultTableModel modelo1){


		try {Connection c=connection.get_connection();
			ResultSet rs=null; 
			

			try {
				String query="SELECT*FROM patient ";

				p=c.prepareStatement(query);
				rs=p.executeQuery();					
				while (rs.next()) {

					String id=rs.getString("patient_id");
					String name=rs.getString("name");
					String lastName=rs.getString("lastName");
					String age=rs.getString("age");
					String status=rs.getString("status");
					String problem=rs.getString("problem");
					String idDoctor=rs.getString("id_doctor");
					
                    String[] datos={id,name,lastName,age,status,problem,idDoctor};

					modelo1.addRow(datos);
				}
												
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public static void borrarCitaDisponibleDB(int x){

		try {Connection c=connection.get_connection();
			try {

				String query="DELETE FROM doctorcites WHERE id_dc=?";
				p=c.prepareStatement(query);
				p.setInt(1,x);
				p.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
