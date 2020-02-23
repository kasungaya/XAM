package UI;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/** 
 * this database connection is for the admin panel data.
 * @author kasun Abeywardana
 */

public class db {
	
	public static Connection mycon() throws ClassNotFoundException, SQLException {

		/**
		 * creating the database connection
		 */
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/xam_test1", "root", "");
        return c;


     }

}
