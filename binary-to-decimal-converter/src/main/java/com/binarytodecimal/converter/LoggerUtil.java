package com.binarytodecimal.converter;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

	private static Logger logger = null;

	static {
		try {
			logger = Logger.getLogger(LoggerUtil.class.getName());
			logger.setLevel(Level.ALL);

			ConsoleHandler consoleHandler = new ConsoleHandler();
			consoleHandler.setLevel(Level.ALL);
			logger.addHandler(consoleHandler);

			logger.setUseParentHandlers(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Logger getLogger() {
		return logger;
	}

}
