package purdue.crowdsense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Create_conn {

	private static Connection con = null;

	public static Connection getConnection(String url, String user, String password){
		if(con == null)
		{
			try{
			con = DriverManager.getConnection(url, user, password);
			}
			catch (SQLException ex) {
         		Logger lgr = Logger.getLogger(Create_conn.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

        		}		

		}
			return con;
	}	 	
}
