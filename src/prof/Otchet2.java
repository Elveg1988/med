package prof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Otchet2 {
	Connection conn;

	public Otchet2(Connection conn) {
		this.conn = conn;
	}

	public void buildCSV() {
		File file1 = new File("sample1.csv");
		String query = "select id, username, ename from emp";
		try (PrintWriter pw = new PrintWriter(file1); Statement stmt = conn.createStatement()) {
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				pw.print(rset.getInt(1));
				pw.print(";");
				pw.print(rset.getString(2));
				pw.print(";");
				pw.print(rset.getString(3));
				pw.print("\n");
			}
		} catch (FileNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
