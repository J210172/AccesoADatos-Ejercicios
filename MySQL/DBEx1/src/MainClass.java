import windows.MainFrame;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.result.Row;

import db.GenericConnections;

public class MainClass {
	public static void main(String[] args) {
		new MainFrame();
		

	}
	
	public static void pru1() {
		try {
			GenericConnections gc = new GenericConnections("users");
			ResultSet res = gc.selAllForm("users");
			ResultSetMetaData rsmd = res.getMetaData();
			String header[];
			int columnSize = rsmd.getColumnCount();
			int rowSize = 10;
			header = new String[columnSize];

			for (int i = 1; i <= columnSize; i++) {
				header[i - 1] = rsmd.getColumnName(i);
			}
			for (String s : header) {
				System.out.print(s + " ");
			}
			System.out.println();
			for (int i = 0; res.next(); i++) {

				for (int j = 1; j <= columnSize; j++) {
					System.out.print(res.getString(j) + " ");
				}

				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void pru2() {
		try {
			Vector<String> data = new Vector<>();
			Vector<String> header = new Vector<>();
			GenericConnections gc = new GenericConnections("users");
			ResultSet res = gc.selAllForm("users");
			ResultSetMetaData rsmd = res.getMetaData();
			int columnSize = rsmd.getColumnCount();

			for (int i = 1; i <= columnSize; i++) {
				header.add(rsmd.getColumnName(i));
			}
			for (String s : header) {
				System.out.print(s + " ");
			}
			for (int i = 0; res.next(); i++) {

				for (int j = 1; j <= columnSize; j++) {
					data.add(res.getString(j));
				}
				
			}
			
			for (String s : data) {
				System.out.println(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
