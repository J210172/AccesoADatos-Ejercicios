import windows.MainFrame;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.result.Row;

import db.GenericConnections;

public class MainClass {
	public static void main(String[] args) {
		GenericConnections gc = new GenericConnections("users");
		
		try {
			ResultSet res = gc.selAllForm("users");
			ResultSetMetaData rsmd = res.getMetaData();
			String header[];
			String rows[][];
			int columnSize = rsmd.getColumnCount();
			int rowSize;
			if (res.last()) {
				rowSize = res.getRow();
				res.beforeFirst();
				header = new String[columnSize];

				rows = new String[rowSize][columnSize];
				
				for (int i = 1; i <= columnSize; i++) {
					header[i-1] = rsmd.getColumnName(i);
				}
				for (String s : header) {
					System.out.print(s + " ");
				}
				System.out.println();
				for (int i = 0; res.next(); i++){
//					System.out.print(res.getInt(1) + " ");
//					System.out.print(res.getString(2) + " ");
//					System.out.print(res.getString(3) + " ");
//					System.out.print(res.getString(4) + " ");
//					System.out.print(res.getString(5) + " ");
//					System.out.print(res.getString(6) + " ");
					
					for (int j = 1; j <= columnSize; j++) {
						rows[i][j] = res.getString(j);
					}
					
					System.out.println();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
