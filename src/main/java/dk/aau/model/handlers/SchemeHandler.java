package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Queryable;
import dk.aau.model.Patient;
import dk.aau.model.Scheme;

public class SchemeHandler implements Queryable{

	private ArrayList<Scheme> schemeList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			Scheme s = new Scheme(rs.getInt("schemeID"), rs.getString("journalNote"),
								  rs.getString("patientCPR"));
			schemeList.add(s);
	}
		
	}

	@Override
	public String returnSqlLoadQuery() {
		String sqlStatement ="SELECT * FROM Scheme"; 
		
		
		return sqlStatement;
	}

	/**
	 * Method for returning the list of schemes
	 * @return The arraylist with all the schemes.
	 */
	public ArrayList<Scheme> getSchemelist(){
		return schemeList;
	}

	@Override
	public String returnUpdateQuery(Object obj) {
		Scheme s = (Scheme) obj;
		
		int sID = s.getSchemeID();
		String jNote = s.getJournalNote();
		
		String sqlUploadStatement = "UPDATE Scheme SET "
				+ "journalNote = \"" + jNote + "\""
				+ " WHERE Scheme.schemeID = " + sID + ";";
		
				
		return sqlUploadStatement;
	}
	

}
