import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
	DBConnection dbConnection;
	public Consultas(String dbName) {
		dbConnection = new DBConnection(dbName);
	}
	
	public Consultas(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public ResultSet consultaLocalidadFormulario1(String cadenaSQL) throws SQLException {
		Statement stmt;
		stmt = dbConnection.createStatement();
		return (stmt.executeQuery(cadenaSQL));
	}
	
	public ResultSet consultaLocalidadFormulario2(String localidad) {
		try {
			PreparedStatement stmt;
			String sentenciaSQL = "SELECT * FROM Socio";
			if (localidad.isEmpty())
				stmt = dbConnection.prepareStatement(sentenciaSQL);
			else {
				sentenciaSQL = "SELECT * FROM Socio WHERE  localidad = ?";
				stmt = dbConnection.prepareStatement(sentenciaSQL);
				stmt.setString(1, localidad);
			}

			return (stmt.executeQuery());

		} catch (SQLException e) {
			return null;
		}
	}
}
