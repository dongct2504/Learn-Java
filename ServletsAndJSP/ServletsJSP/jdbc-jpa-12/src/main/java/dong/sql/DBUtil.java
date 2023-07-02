package dong.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.oracle.wls.shaded.org.apache.bcel.util.ClassPath;

public class DBUtil {

	private static final String DB_URL = "db.url";
	private static final String DB_USERNAME = "db.username";
	private static final String DB_PASSWORD = "db.password";

	private static Properties properties = null;
	private static MysqlDataSource dataSource = null;

	static {
		try {
			//			Path path = Paths.get(
			//					"C:\\Users\\Administrator\\Documents\\Programming\\JakartaEE\\ServletsAndJSP\\ServletsJSP\\jdbc-jpa-12\\src\\main\\resources\\database.properties");

			//			Path path = Paths.get("src/main/resources/database.properties");

			//			URL resourceUrl = DBUtil.class.getResource("/database.properties");
			//			Path path = Paths.get(resourceUrl);

			//			Path path = new File(DBUtil.class.getResource("/database.properties").getFile()).toPath();

//			File filePath = new File(DBUtil.class.getResource("/database.properties").getFile());
			ClassLoader context = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = context.getResourceAsStream("dong/database.properties");
			
			properties = new Properties();
//			properties.load(new FileInputStream(filePath.getAbsoluteFile()));
			properties.load(inputStream);

			dataSource = new MysqlDataSource();
			dataSource.setUrl(properties.getProperty(DB_URL));
			dataSource.setUser(properties.getProperty(DB_USERNAME));
			dataSource.setPassword(properties.getProperty(DB_PASSWORD));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void main(String[] args) throws SQLException {
		DBUtil.getConnection();
	}

}
