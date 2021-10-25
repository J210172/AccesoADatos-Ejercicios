package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenericConnections {
	private String driver;
	private String database;
	private String hostname;
	private String port;
	private String url;
	private String username;
	private String password;
	private Statement stmt;
	private Connection connection;

	public GenericConnections() {
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.database = "baloncesto";
		this.hostname = "localhost";
		this.port = "3306";
		this.url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
		this.username = "root";
		this.password = "root";
		connect();
	}

	public GenericConnections(String database) {
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.database = database;
		this.hostname = "localhost";
		this.port = "3306";
		this.url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
		this.username = "root";
		this.password = "root";
		connect();

	}

	public GenericConnections(String user, String passwrd) {
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.database = "baloncesto";
		this.hostname = "localhost";
		this.port = "3306";
		this.url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
		this.username = "root";
		this.password = "root";
		connect();
	}

	public GenericConnections(String database, String user, String passwrd) {
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.database = database;
		this.hostname = "localhost";
		this.port = "3306";
		this.url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
		this.username = user;
		this.password = passwrd;
		connect();
	}

	private void connect() {
		try {
			DriverManager.getDriver(url);
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodos
	/*
	 * TODO: Crear metodo para preparados
	 * 
	 * use users; SELECT * FROM users.users;
	 * 
	 * PREPARE user_insert FROM "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?)"; <--
	 * Solo una vez SET @first_name = "Pepe", @last_name = "Palos", @email =
	 * "PepePalos@GotMemed.mem", @password = "PAwepXD69ndp", @gender = "Mayonnaise";
	 * EXECUTE user_insert
	 * USING @id, @first_name, @last_name, @email, @password, @gender;
	 * 
	 * SELECT * FROM users.users where users.first_name = 'Pepe';
	 */
	

	public ResultSet consultaLocalidadFormulario1(String cadenaSQL) throws SQLException {
		Statement stmt;
		stmt = connection.createStatement();
		return (stmt.executeQuery(cadenaSQL));
	}
	
	public ResultSet selAllForm(String tabla) {
		try {
			PreparedStatement stmt;
			String sentenciaSQL = null;
			if (tabla.isEmpty())
				stmt = connection.prepareStatement(sentenciaSQL);
			else {
				sentenciaSQL = "SELECT * FROM " + tabla;
				stmt = connection.prepareStatement(sentenciaSQL);
			}
			return (stmt.executeQuery());
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	public String getDriver() {
		return driver;
	}

	public String getDatabase() {
		return database;
	}

	public String getHostname() {
		return hostname;
	}

	public String getPort() {
		return port;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	@Override
	public String toString() {
		return "DBConnection:\n\t[driver = \"" + driver + "\"]\n\t[url = \"" + url + "\"]\n\t[username = \"" + username
				+ "\", password = \"" + password + "\"]";
	}

}
