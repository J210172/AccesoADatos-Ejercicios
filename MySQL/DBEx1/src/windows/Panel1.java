package windows;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class Panel1 extends JPanel {
	private JTable table;
	public Panel1() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new String[][] {
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
				{"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"},
			},
			new String[] {
				"ID", "Nombre", "FirstName", "LastName", "Passwrd", "Gender"
			}
		));
		add(table);
		setBackground(Color.BLACK);
	}
}
