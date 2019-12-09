package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import com.mysql.cj.jdbc.Driver;

import dk.aau.model.Patient;


//PatientList to return to main.


public class DatabaseController {
	//Patientlist to fill and return to main.
	private static List<Patient> pList = new ArrayList<>();
	
	
	
	
	
	
	public static Connection getConnection(){
		Connection conn = null;
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			
			conn = DriverManager.getConnection(DatabaseDetails.host, DatabaseDetails.username, DatabaseDetails.password);
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		return conn; 
	}
	
	
	
	public static void ExecuteQueryWithResultSet(Queryable queryable){
			ExecuteQueryWithResultSet(queryable.returnSqlLoadQuery(),queryable);
	}
	
	
	public static void ExecuteQueryWithResultSet(String sqlStatement, Queryable queryable){
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		if(conn!=null){
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlStatement);
				
				
				queryable.processResultset(rs);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			finally {
				
				try {
					rs.close();
					
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
				
				try {
					stmt.close();
					
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
				
			}
			
		}
		
		
		
	}
	
	public static int ExecuteUploadStatement(Queryable queryable, Object obj){
		Connection conn = getConnection();
		Statement stmt = null;
		int result = -1;
		String sqlStatement = queryable.returnUpdateQuery(obj);
		
		if(conn!=null){
			try {
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sqlStatement);
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			finally {
								
				try {
					stmt.close();
					
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
				
			}
			
		}
		
		return result;
		
	}
	
}
