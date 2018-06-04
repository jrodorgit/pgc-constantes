package net.rodor.pgcconstantes.logging;

public class LoggerRodor implements LoggerRodorInt {

	//private String name;
	private org.apache.logging.log4j.Logger logger;
	public LoggerRodor(String name) {
		super();
		//this.name = name;
		logger = LoggerFactory.getInstance().getLogger(name);
	}
	
	public void debug(String msg) {
		logger.debug(msg);
	}
	
}

