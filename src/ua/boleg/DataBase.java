package ua.boleg;

import java.sql.*;
import java.util.Calendar;

public class DataBase {

	private static final String URL = "jdbc:mysql://localhost:3306/utilities?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "sqroot";
	private static final String ADD = "UPDATE `utilities`.`utilites` SET `name`=?, `last`=?, `value`=?, "
			+ "`price`=?, `result`=?, `date`=? WHERE `id`=?;";
	


	Connection con;
	PreparedStatement pr;
	// Connect to database
	public DataBase(Service s) {

		try {
			
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pr = con.prepareStatement(ADD);
			pr.setString(1, s.getName());
			pr.setDouble(2, s.getValue()); // last
			pr.setDouble(3, s.getValue());
			pr.setDouble(4, s.getPrice());
			pr.setDouble(5, s.getResult());
//			pr.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pr.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
			pr.setInt(7, s.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Эта часть позволяет нам закрыть все открытые ресуры
			// В противном случае возмжожны проблемы. Поэтому будьте
			// всегда аккуратны при работе с коннектами
			try {
				if (pr != null) {
					pr.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}

	}
}
