package net.rodor.pgcconstantes.logging;

public class LoggerFactory {

	private static LoggerFactory instance = null;

	private LoggerFactory() {
		
	}
	
	public static LoggerFactory getInstance( ) {
		if(instance == null) {
	         instance = new LoggerFactory();
	      }

	      return instance;
	}
	
	public org.apache.logging.log4j.Logger getLogger(String name){
		return org.apache.logging.log4j.LogManager.getLogger(name);
		
	}
	
}
