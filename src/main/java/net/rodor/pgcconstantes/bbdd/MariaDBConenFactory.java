package net.rodor.pgcconstantes.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MariaDBConenFactory {

	private  static MariaDBConenFactory instance;
	private MariaDBConenFactory(){}
	public  static MariaDBConenFactory getInstance(){
		if(instance == null){
			instance = new MariaDBConenFactory();
		}
		return instance;
	}

	public Connection getDBConnection() throws SQLException {

	    Connection conn = null;
	   
	    conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pgc?user=jrodor&password=slug101");
	    return conn;
	}
}
