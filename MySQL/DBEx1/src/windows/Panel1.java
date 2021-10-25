package windows;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import db.GenericConnections;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;

public class Panel1 extends JPanel {
	private JTable table;

	public Panel1() {
		setInfo();
		setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		setBackground(Color.BLACK);
	}

	private void setInfo() {
		Vector<Vector<String>> data = new Vector<>();
		ArrayList<String> tempD = new ArrayList<>();
		Vector<String> header = new Vector<>();
		try {
			GenericConnections gc = new GenericConnections("users");
			ResultSet res = gc.selAllForm("users");
			ResultSetMetaData rsmd = res.getMetaData();
			int columnSize = rsmd.getColumnCount();

			for (int i = 1; i <= columnSize; i++) {
				header.add(rsmd.getColumnName(i));
			}

			for (int i = 0; res.next(); i++) {
				tempD = new ArrayList<>();

				for (int j = 1; j <= columnSize; j++) {
					tempD.add(res.getString(j));
				}
				data.add(new Vector<>(tempD));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
