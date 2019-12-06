package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.Queryable;
import dk.aau.model.Patient;
import Database.DatabaseController;;

public class PatientHandler implements Queryable{
	
	private ArrayList<Patient> patientList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			Patient p = new Patient(rs.getString("cpr"), rs.getString("patientFirstName"), rs.getString("patientLastName"), 
									rs.getString("phoneNumber"),rs.getString("emergencyContactName"), 
									rs.getString("emergencyContactPhoneNumber"),rs.getString("streetName"));
			patientList.add(p);
	}
		
	}

	@Override
	public String returnSqlQuery() {
		String sqlStatement ="SELECT * FROM Patient"; 
		
		
		return sqlStatement;
	}

	/**
	 * Method for returning the list of patients
	 * @return The arraylist with all the patients.
	 */
	public ArrayList<Patient> getPatientlist(){
		return patientList;
	}
}
