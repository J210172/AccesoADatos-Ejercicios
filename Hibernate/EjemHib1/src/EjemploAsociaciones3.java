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

		String hql = "from Empleados";
		Query cons = session.createQuery(hql);
		List<Empleados> empleados = cons.list();

<<<<<<< HEAD
		Query cons2 = session.createQuery("from empleados where empno = 1");
		if (cons.uniqueResult() == null) {
			
		}
		
		MyFrame myF = new MyFrame(empleados.stream().map(Empleados::getSalario).toArray(Float[]::new));
		
		session.close();		
=======
		Query cons2 = session.createQuery("from Empleados where empNo = :num");
		cons2.setInteger("num", 1);
		if (cons2.uniqueResult() == null) {
			Empleados e = (Empleados) cons2.uniqueResult();		
		}
		
		String list1[] = empleados.stream().map(Empleados::getApellido).toArray(String[]::new);
		Float list2[] = empleados.stream().map(Empleados::getSalario).toArray(Float[]::new);
		MyFrame myF = new MyFrame(list1, list2);
//		MyFrame myF = new MyFrame();
//		empleados.forEach(myF::addItem);

		session.close();
>>>>>>> 7ce590023c5661e7ee2297583f5c0af2c1ff7601
	}
}

class MyFrame extends JFrame {
	private JPanel contentPane;
<<<<<<< HEAD
	private JComboBox<Float> myCB;
	
	public MyFrame(Float[] lista) {
		setUp();
		myCB.setModel(new DefaultComboBoxModel<Float>(lista));
=======
	private JComboBox<String> myCB1;
	private JComboBox<Float> myCB2;

	public MyFrame(String[] lista, Float[] listaSal) {
		setUp();
		myCB1.setModel(new DefaultComboBoxModel<String>(lista));
		myCB2.setModel(new DefaultComboBoxModel<Float>(listaSal));
>>>>>>> 7ce590023c5661e7ee2297583f5c0af2c1ff7601
	}

	public MyFrame() {
		setUp();
	}

	void setUp() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);

		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
<<<<<<< HEAD
		
		myCB = new JComboBox<>();
		myCB.getModel().addListDataListener(myCB);
		contentPane.add(myCB);
		
=======

		myCB1 = new JComboBox<>();
		contentPane.add(myCB1);

		myCB2 = new JComboBox<>();
		contentPane.add(myCB2);


>>>>>>> 7ce590023c5661e7ee2297583f5c0af2c1ff7601
		setVisible(true);
	}

	public void addItem(Empleados emp) {
<<<<<<< HEAD
		myCB.addItem(emp.getSalario());
=======
		myCB1.addItem(emp.getApellido());
>>>>>>> 7ce590023c5661e7ee2297583f5c0af2c1ff7601
	}
}