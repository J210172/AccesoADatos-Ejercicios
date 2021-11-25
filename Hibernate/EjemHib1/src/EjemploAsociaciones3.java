import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Empleados;
import primero.SessionFactoryUtil;

public class EjemploAsociaciones3 {
	public static void main(String[] args) {
		//

		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();

		String hql = "from Empleados where oficio = 'DIRECTOR'";
		Query cons = session.createQuery(hql);

		MyFrame myF = new MyFrame(cons.list().stream().map((Empleados obj) -> obj.getApellido()));

		session.close();
		System.exit(0);

	}
}

class MyFrame extends JFrame {
	private JPanel contentPane;

	public MyFrame(String[] lista) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);	
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JComboBox<String> myCB = new JComboBox<>(lista);
		contentPane.add(myCB);
		
		setVisible(true);
	}

	public MyFrame(Class<Arrays> class1) {
		// TODO Auto-generated constructor stub
	}
}
