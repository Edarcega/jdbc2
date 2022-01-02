package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null; // Conectar no banco
		Statement st = null; // Preparar consulta
		ResultSet rs = null; // Guardar no RS
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();// Instancia objeto do tipo statement
			rs = st.executeQuery("select * from department");
		
			while (rs.next()){
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}

	}

}
