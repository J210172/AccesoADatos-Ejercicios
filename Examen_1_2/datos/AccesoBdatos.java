

import java.sql.*;
import java.util.ArrayList;
public class AccesoBdatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "pedidos5nov21";
    private static String hostname = "localhost";
    private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "root";
   private static Connection conecta;
	
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}
	
	public void desconectar() throws SQLException, ClassNotFoundException {
		
		conecta = null; // = conecta.close();
	}

public static Connection getConecta() {
		return conecta;
	}
	
	// COMPLETAR
}