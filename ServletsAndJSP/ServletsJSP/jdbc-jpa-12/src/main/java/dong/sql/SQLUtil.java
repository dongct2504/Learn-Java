package dong.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLUtil {

	public static String getHtmlTable(ResultSet rs) throws SQLException {
		StringBuilder sb = new StringBuilder();
		ResultSetMetaData metadata = rs.getMetaData();
		int columnCount = metadata.getColumnCount();
		
		sb.append("<table>");
		
		// add header row
		sb.append("<tr>");
		for (int i = 1; i <= columnCount; i++) {
			sb.append("<th>");
			sb.append(metadata.getColumnName(i));
			sb.append("</th>");
		}
		sb.append("</tr>");
		
		// add all other rows
		while (rs.next()) {
			sb.append("<tr>");
			for (int i = 1; i <= columnCount; i++) {
				sb.append("<td>");
				sb.append(rs.getString(i));
				sb.append("</td>");
			}
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		
		return sb.toString();
	}
}











