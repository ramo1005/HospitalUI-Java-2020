/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramon.proyectofinal.modelos;

import com.ramon.proyectofinal.databases.ConnectionMySQL;
import static com.ramon.proyectofinal.modelos.DoctorDAO.doctorOnline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.ResultSet;
/**
 *
 * @author el_an
 */
public class ReportDAO {

    public static ConnectionMySQL connection=new ConnectionMySQL();
    public static PreparedStatement p=null;

    public static void listarPacienteDB(javax.swing.table.DefaultTableModel modelo){


		try {Connection c=connection.get_connection();
			ResultSet rs=null; 
			

			try {
				String query="SELECT*FROM patient WHERE id_doctor="+doctorOnline;

				p=c.prepareStatement(query);
				rs=p.executeQuery();					
				while (rs.next()) {

					String name=rs.getString("name");
					String lastName=rs.getString("lastName");
					String age=rs.getString("age");
					String status=rs.getString("status");
					String problem=rs.getString("problem");
					String idDoctor=rs.getString("id_doctor");
					
                    String[] datos={name,lastName,age,status,problem,idDoctor};

					modelo.addRow(datos);
				}
												
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

    }
    public static void listarPacienteUrgenteDB(javax.swing.table.DefaultTableModel modelo1){


		try {Connection c=connection.get_connection();
			ResultSet rs=null; 
			

			try {
				String query="SELECT*FROM urgent";

				p=c.prepareStatement(query);
				rs=p.executeQuery();					
				while (rs.next()) {

					String name=rs.getString("name");
					String lastName=rs.getString("lastName");
					String age=rs.getString("age");
					String status=rs.getString("status");
					String problem=rs.getString("problem");
					
                    String[] datos={name,lastName,age,status,problem};

					modelo1.addRow(datos);
				}
												
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
    
}
