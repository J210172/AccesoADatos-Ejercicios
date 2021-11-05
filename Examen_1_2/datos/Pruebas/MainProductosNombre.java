import java.sql.SQLException;
import java.util.ArrayList;

public class MainProductosNombre {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AccesoBdatos abd=new AccesoBdatos();
		abd.conectar();
		String nombre ="CARNE";		
		ArrayList<Producto> lista = abd.productosNombre(nombre);
		for (Producto p : lista)
			System.out.println(p);
		System.out.println("Fin listado");
		abd.desconectar();
	}
}
