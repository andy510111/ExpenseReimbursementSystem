package projectone.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection conn;

	public static Connection getConnection() throws SQLException, IOException {
		System.out.println("Getting connection......");
		try {
			FileInputStream propInput = new FileInputStream(
					"C:\\Users\\User\\Documents\\GitRepos\\Notes\\Notes\\project1\\projectone\\src\\main\\resources\\config.properties");
			Properties props = new Properties();
			props.load(propInput);
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = (String) props.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successful");
			return conn;
		} catch (Exception e) {
			System.out.println("Unable to connect");
			e.printStackTrace();
		}
		return null;
	}

}
