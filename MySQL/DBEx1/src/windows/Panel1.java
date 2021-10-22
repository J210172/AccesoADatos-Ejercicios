package windows;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Component;

public class Panel1 extends JPanel {
	private JTable table;
	public Panel1() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		setInfo();
		add(new JScrollPane(table), BorderLayout.CENTER);
		setBackground(Color.BLACK);
	}
	
	private void setInfo() {
		
		table.setModel(null);
	}
}
