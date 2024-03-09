package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jLogging {
	
	public static Logger logger = LogManager.getLogger(log4jLogging.class);
	
	public static void main (String []args)	{
		
		logger.info("Info");
		logger.error("Error");
		logger.warn("warn");
		logger.fatal("fatal");
		logger.trace("Trace");
		
	}

}
