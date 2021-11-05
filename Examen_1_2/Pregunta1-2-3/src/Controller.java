
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class Controller implements ActionListener {
	private View view;

	// CONSTRUCTOR
	Controller(View view) {
		this.view = view;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AccesoBdatos abd = new AccesoBdatos();
		try {
			abd.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conecta = abd.getConecta();
		
		abd.insertarEmpresa(view.txtNombre.getText(), view.txtTelefono.getText());
		/*
		 * COMPLETAR
		 */

		limpia();
		try {
			abd.desconectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Método para limpiar los campos de la ventana
	private void limpia() {
		this.view.txtNombre.setText("");
		this.view.txtTelefono.setText("");

	}

}