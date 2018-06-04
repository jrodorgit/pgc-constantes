package net.rodor.pgcconstantes.bbdd;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnFactory {

	private static final int FACTORIA_CONN = 3;
	private static final int ORACLE_CONN_FACTORY = 1;
	private static final int SPRING_DS_FACTORY = 2;
	private static final int MARIADB_CONN_FACTORY = 3;
	
	private  static DataBaseConnFactory instance;
	private DataBaseConnFactory(){}
	public  static DataBaseConnFactory getInstance(){
		if(instance == null){
			instance = new DataBaseConnFactory();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		switch (FACTORIA_CONN) {
        	case ORACLE_CONN_FACTORY:
        		conn = OracleConnFactory.getInstance().getDBConnection();
        		break;
        	case SPRING_DS_FACTORY:
        		conn = SpringDBConnFactory.getInstance().getDBConnection();
                break;
        	case MARIADB_CONN_FACTORY:
        		conn = MariaDBConenFactory.getInstance().getDBConnection();
                break;
                
        	default: 
        		conn = MariaDBConenFactory.getInstance().getDBConnection();
                break;
		}

		return conn;
	}
}
