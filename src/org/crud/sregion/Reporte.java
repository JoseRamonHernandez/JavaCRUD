package org.crud.sregion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * CURD PARA LA TABLA DE REPORTES
 * 
 * */

import java.io.IOException;

public class Reporte {

	// CONEXION A LA BASE DE DATOS
		private static Connection connection = null;
		private static String driver = "oracle.jdbc.driver.OracleDriver";
		private static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		private static void connectDataBaseOracle() throws IOException, SQLException{
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Cargó driver correctamente: ojdbc.jar");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception: "+e.getMessage());
			}
			
			try {
				
				connection = DriverManager.getConnection(URL, "SYSTEM", "246856");
				System.out.println("Conexión EXITOSA!! : ORACLE 11G");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception: "+e.getMessage());
			}
			
		}
		
		
		//INSERTAR DATOS
		public static void insertarReporte(int id, String name, String date, String description) throws IOException, SQLException
		{
			try {
				
				connectDataBaseOracle();
				String sql = "INSERT INTO REPORTE (ID, NOMBRE, FECHA, DESCRIPCION) VALUES (?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, date);
				ps.setString(4, description);
				ps.executeQuery();
				
				System.out.println("Inserto el Registro correctamente!!");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception: "+e.getMessage());
			}
			
		}
		
		
		//ACTUALIZAR DATOS
		public static void updateReporte(String name, int id) throws IOException, SQLException
		{
			try {
				
				connectDataBaseOracle();
				String sql = "UPDATE REPORTE SET NOMBRE = ? WHERE ID = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, name);
				ps.setInt(2, id);
				ps.executeQuery();
				
				System.out.println("Se actualizó el Registro correctamente!!");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception: "+e.getMessage());
			}
			
		}
		
		
		//INSERTAR DATOS
		public static void deleteReporte(int id) throws IOException, SQLException
		{
			try {
				
				connectDataBaseOracle();
				String sql = "DELETE FROM REPORTE WHERE ID = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeQuery();
				
				System.out.println("Se eliminó el Registro correctamente!!");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception: "+e.getMessage());
			}
			
		}
		
		
		//CONSULTAR POR ID
		public static void selectReporte(int id) throws IOException, SQLException
		{
			try {
						
			connectDataBaseOracle();
			String consulta = "SELECT * FROM REPORTE WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setInt(1, id);
			ResultSet rSet = ps.executeQuery();
			if(rSet.next())
			{
				System.out.println(rSet.getInt("id")+", "+rSet.getString("nombre")+", "+rSet.getString("fecha")+", "+rSet.getString("descripcion"));
			}
						
			} catch (Exception e) {
				// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
			}
					
		}
		
		
		//GET ALL REGISTER
		public static void selectAllReporte() throws IOException, SQLException
		{
			try {
						
			connectDataBaseOracle();
			String consulta = "SELECT * FROM REPORTE";
			PreparedStatement ps = connection.prepareStatement(consulta);
			ResultSet rSet = ps.executeQuery();
			while(rSet.next())
			{
				System.out.println(rSet.getInt("id")+", "+rSet.getString("nombre")+", "+rSet.getString("fecha")+", "+rSet.getString("descripcion"));
			}
						
			} catch (Exception e) {
				// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
			}
					
		}
		
		
		public static void main(String[] args)  throws IOException, SQLException {
			
			//connectDataBaseOracle();
			//insertarReporte(3, "Reporte3", "21-03-2023", "Description of the Report3");
			//updateReporte("Esquema Organizacional 2020-2023", 1);
			//deleteReporte(1);
			//selectReporte(1);
			selectAllReporte();
			
		}
	
}
