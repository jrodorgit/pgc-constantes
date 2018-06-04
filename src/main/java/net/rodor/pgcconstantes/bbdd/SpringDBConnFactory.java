package net.rodor.pgcconstantes.bbdd;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDBConnFactory {

	private  static SpringDBConnFactory instance;
	private SpringDBConnFactory(){}
	public  static SpringDBConnFactory getInstance(){
		if(instance == null){
			instance = new SpringDBConnFactory();
		}
		return instance;
	}
	
	public Connection getDBConnection() throws SQLException {

	    Connection conn = null;
	    ApplicationContext context = new ClassPathXmlApplicationContext("net/rodor/pgcconstantes/Beans.xml");
	    DataSource ds = (DataSource) context.getBean("dataSource");
	    conn = ds.getConnection();
	    
	    return conn;
	}
}
