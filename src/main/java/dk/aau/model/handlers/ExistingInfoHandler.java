package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Queryable;
import dk.aau.model.ExistingInfo;
import dk.aau.model.Patient;

public class ExistingInfoHandler implements Queryable{
	private ArrayList<ExistingInfo> existingInfoList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			ExistingInfo e = new ExistingInfo(rs.getInt("questionID"), rs.getString("question"),
							rs.getString("patientComment"), rs.getString("obtainedInformation"), 
							rs.getInt("schemeID"));
			existingInfoList.add(e);
	}
		
	}

	@Override
	public String returnSqlLoadQuery() {
		String sqlStatement ="SELECT * FROM ExistingInformation"; 
		
		
		return sqlStatement;
	}

	/**
	 * Method for returning the list of existingInfos
	 * @return The arraylist with all the existingInfos.
	 */
	public ArrayList<ExistingInfo> getExistingInfolist(){
		return existingInfoList;
	}

	@Override
	public String returnUpdateQuery(Object obj) {
		ExistingInfo e = (ExistingInfo) obj;
		
		int qID = e.getExistingInfoID();
		String obtainedInfo = e.getobtainedInfoText();
		String patientComment = e.getpatientCommentText();
		
		String sqlUploadStatement = "UPDATE ExistingInformation SET "
				+ "obtainedInformation = \"" + obtainedInfo + "\""
				+ ", patientComment = \"" + patientComment + "\""
				+ " WHERE ExistingInformation.questionID = " + qID + ";";
		
		// TODO Auto-generated method stub
		return sqlUploadStatement;
	}


}
