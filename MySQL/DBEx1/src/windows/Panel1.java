package windows;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;

import db.GenericConnections;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

public class Panel1 extends JPanel {
	private JTable table;

	public Panel1() {
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.BLACK);
		
		table = new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setInfo();
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Mi tabla");
		panel.add(lblNewLabel);
	}

	private void setInfo() {
		Vector<Vector<String>> data = new Vector<>();
		Vector<String> tempD = new Vector<>();
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
				tempD = new Vector<>();

				for (int j = 1; j <= columnSize; j++) {
					tempD.add(res.getString(j));
//					System.out.println(res.getString(j));
				}
				data.add(tempD);
			}
			table.setModel(new DefaultTableModel(data, header));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
