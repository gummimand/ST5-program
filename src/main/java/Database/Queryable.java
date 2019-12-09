package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dk.aau.model.Patient;;

public interface Queryable {
	void processResultset(ResultSet rs) throws SQLException;
	String returnSqlLoadQuery();
	String returnUpdateQuery(Object obj);
}
