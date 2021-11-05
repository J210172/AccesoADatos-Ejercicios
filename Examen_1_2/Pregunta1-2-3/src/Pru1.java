import java.sql.SQLException;

public class Pru1 {
	public static void main(String[] args) {
		AccesoBdatos abd = new AccesoBdatos();
		try {
			abd.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Producto p : abd.productosCategoria(1)) {
			System.out.println(p);
		}
	}
}
