package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;;

public interface Queryable {
	void processResultset(ResultSet rs) throws SQLException;
	String returnSqlQuery();
}
