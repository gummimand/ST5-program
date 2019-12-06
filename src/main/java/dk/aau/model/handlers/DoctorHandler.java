package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Queryable;
import dk.aau.model.Doctor;

public class DoctorHandler implements Queryable{
	private ArrayList<Doctor> doctorList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			Doctor d = new Doctor(rs.getInt("doctorID"), rs.getString("doctorFirstName"), rs.getString("doctorLastName"));
			doctorList.add(d);
	}
		
	}

	@Override
	public String returnSqlQuery() {
		String sqlStatement ="SELECT * FROM Doctor"; 
		
		
		return sqlStatement;
	}

	/**
	 * Method for returning the list of doctors
	 * @return The arraylist with all the doctors.
	 */
	public ArrayList<Doctor> getDoctorlist(){
		return doctorList;
	}

}
