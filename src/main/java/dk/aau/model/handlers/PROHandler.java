package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Queryable;
import dk.aau.model.PRO;
import dk.aau.model.Patient;

public class PROHandler implements Queryable{
	private ArrayList<PRO> proList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			PRO p = new PRO(rs.getInt("questionID"), rs.getString("question"),
							rs.getString("questionTextAnswer"), rs.getString("doctorNote"), rs.getInt("schemeID"));
			proList.add(p);
	}
		
	}

	@Override
	public String returnSqlLoadQuery() {
		String sqlStatement ="SELECT * FROM PRO"; 
		
		
		return sqlStatement;
	}

	/**
	 * Method for returning the list of pros
	 * @return The arraylist with all the pros.
	 */
	public ArrayList<PRO> getPROlist(){
		return proList;
	}

	@Override
	public String returnUpdateQuery(Object obj) {
		PRO pro = (PRO) obj;
		
		int qID = pro.getProID();
		String questionTAnswer = pro.getquestionTextAnswer();
		String dNote = pro.getdoctorNote();
		
		String sqlUploadStatement = "UPDATE `PRO` SET "
				+ "questionTextAnswer = \"" + questionTAnswer + "\""
				+ ", doctorNote = \"" + dNote + "\""
				+ " WHERE `PRO`.`questionID` = " + qID + ";";
		
		
		return sqlUploadStatement;
	}


}
