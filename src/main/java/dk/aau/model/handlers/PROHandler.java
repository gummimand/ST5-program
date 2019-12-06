package dk.aau.model.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Queryable;
import dk.aau.model.PRO;

public class PROHandler implements Queryable{
	private ArrayList<PRO> proList = new ArrayList<>();

	@Override
	public void processResultset(ResultSet rs) throws SQLException {
		while(rs.next()){
			PRO p = new PRO(rs.getInt("questionID"), rs.getString("question"),
							rs.getString("questionTextAnswer"), rs.getInt("schemeID"));
			proList.add(p);
	}
		
	}

	@Override
	public String returnSqlQuery() {
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


}
