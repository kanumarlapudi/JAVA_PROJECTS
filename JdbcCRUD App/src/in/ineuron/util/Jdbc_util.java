package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Jdbc_util {

	private Jdbc_util() {
	}

	static {
		try {
			// Step1: loading and register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws IOException, SQLException {
		// Take the data from properties file
		FileInputStream fis = new FileInputStream("D:\\Projects\\JdbcCRUD App\\Properties");
		Properties properties = new Properties();
		properties.load(fis);

		// Step2. Establish the Connection
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;

	}

	public static void closeUp(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
			throws SQLException {

		if (connection != null) {
			connection.close();
		}

		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (resultSet != null) {
			resultSet.close();
		}

	}
}
