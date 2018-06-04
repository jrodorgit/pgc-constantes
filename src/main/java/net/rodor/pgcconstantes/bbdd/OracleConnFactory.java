package net.rodor.pgcconstantes.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnFactory {
	
	private  static OracleConnFactory instance;
	private OracleConnFactory(){}
	public  static OracleConnFactory getInstance(){
		if(instance == null){
			instance = new OracleConnFactory();
		}
		return instance;
	}

	public Connection getDBConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", "ayflo");
	    connectionProps.put("password", "ayflo");

	    conn = DriverManager.getConnection("jdbc:oracle:thin:@ldap://oraoid1.portal.ss:389/DS10_SCAN,cn=OracleContext,dc=portal,dc=ss ldap://oraoid2.portal.ss:4032/DS10_SCAN,cn=OracleContext,dc=portal,dc=ss",
                		connectionProps);
	    
	    return conn;
	}
}
