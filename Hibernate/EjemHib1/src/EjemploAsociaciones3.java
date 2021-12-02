import java.awt.FlowLayout;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicSplitPaneUI.BasicHorizontalLayoutManager;
import javax.swing.text.FlowView;

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
		List<Empleados> empleados = cons.list();


		Query cons2 = session.createQuery("from empleados where empno = 1");
		if (cons.uniqueResult() == null) {
			
		}
		
		MyFrame myF = new MyFrame(empleados.stream().map(Empleados::getApellido).toArray(String[]::new));
//		MyFrame myF = new MyFrame();
//		empleados.forEach(myF::addItem);
		
		session.close();		
	}
}

class MyFrame extends JFrame {
	private JPanel contentPane;
	private JComboBox<String> myCB;
	
	public MyFrame(String[] lista) {
		setUp();
		myCB.setModel(new DefaultComboBoxModel<String>(lista));
	}
	
	public MyFrame() {
		setUp();
	}
	
	void setUp() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);	
		
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		myCB = new JComboBox<>();
		contentPane.add(myCB);
		
		setVisible(true);
	}
	
	public void addItem(Empleados emp) {
		myCB.addItem(emp.getApellido());
	}
}