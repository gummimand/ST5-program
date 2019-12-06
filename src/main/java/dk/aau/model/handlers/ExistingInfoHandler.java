package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Queryable;
import dk.aau.model.ExistingInfo;

public class ExistingInfoHandler implements Queryable{
	private ArrayList<ExistingInfo> existingInfoList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			ExistingInfo p = new ExistingInfo(rs.getInt("questionID"), rs.getString("question"),
							rs.getString("obtainedInformation"), rs.getInt("schemeID"));
			existingInfoList.add(p);
	}
		
	}

	@Override
	public String returnSqlQuery() {
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


}
