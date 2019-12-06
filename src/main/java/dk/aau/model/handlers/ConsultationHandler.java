package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Queryable;
import dk.aau.model.Consultation;

public class ConsultationHandler implements Queryable{
	private ArrayList<Consultation> consultationList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			Consultation c = new Consultation(rs.getString("timeOfConsultation"), rs.getString("dateOfConsultation"),
											  rs.getInt("doctorID"), rs.getInt("schemeID"));
			consultationList.add(c);
	}
		
	}

	@Override
	public String returnSqlQuery() {
		String sqlStatement ="SELECT * FROM Consultation"; 
		
		
		return sqlStatement;
	}

	/**
	 * Method for returning the list of consultations
	 * @return The arraylist with all the consultations.
	 */
	public ArrayList<Consultation> getConsultationlist(){
		return consultationList;
	}
}
