
import java.sql.*;
import java.util.ArrayList;

public class AccesoBdatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "pedidos5nov21";
	private static String hostname = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
			+ "?serverTimezone=Europe/Madrid";
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
	public ArrayList<Producto> productosCategoria(int categoria) {
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Producto> listaProductos = new ArrayList<>();
		try {
			ps = conecta.prepareStatement("SELECT * FROM productos WHERE idcategoria = ?");
			ps.setInt(1, categoria);
			rs = ps.executeQuery();

			while (rs.next()) {
				listaProductos.add(new Producto(rs.getLong("idProducto"), rs.getString("nombreProducto"),
						rs.getLong("idProveedor"), rs.getLong("idCategoria"), rs.getString("cantidadPorUnidad"),
						rs.getDouble("precioUnidad"), rs.getInt("unidadesEnExistencia")));
			}
			return listaProductos;
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}
		return null;
	}

	public int incrementarPrecioProducto(long idProducto, double porcentaje) {
		PreparedStatement ps;
		try {
			conecta.setAutoCommit(false);
			ps = conecta
					.prepareStatement("UPDATE productos SET precioUnidad = precioUnidad * (?+1) WHERE idProducto = ?");
			ps.setDouble(1, porcentaje);
			ps.setLong(2, idProducto);
			int nRows = ps.executeUpdate();
			conecta.commit();
			return nRows;
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}
		try {
			conecta.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Producto> productosNombre(String nombre) {
		CallableStatement cs;
		ResultSet rs;
		ArrayList<Producto> listaProductos = new ArrayList<>();
		try {
			cs = conecta.prepareCall("CALL productosContieneNombre(?)");
			cs.setString(1, nombre);
			rs = cs.executeQuery();
			while (rs.next()) {
				listaProductos.add(new Producto(rs.getLong("idProducto"), rs.getString("nombreProducto"),
						rs.getLong("idProveedor"), rs.getLong("idCategoria"), rs.getString("cantidadPorUnidad"),
						rs.getDouble("precioUnidad"), rs.getInt("unidadesEnExistencia")));
			}
			return listaProductos;
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void insertarEmpresa(String nombre, String telefono) {
		CallableStatement cs;
		try {
			conecta.setAutoCommit(false);
			cs = conecta.prepareCall("Call nuevaEmpresa(?, ?)");
			cs.setString(1, nombre);
			cs.setString(2, telefono);

			boolean nRows = cs.execute();
			conecta.commit();
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			try {
				conecta.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}