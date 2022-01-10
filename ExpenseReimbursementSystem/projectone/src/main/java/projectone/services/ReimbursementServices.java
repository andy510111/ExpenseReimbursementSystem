package projectone.services;

import org.apache.log4j.Logger;

import projectone.controller.ReimbursementController;

public class ReimbursementServices {

	private static final Logger logger = Logger.getLogger(ReimbursementServices.class);
	
	public static int generateRandomNum() {
		logger.info("Generating random number");
		int min = 1;
		int max = 1000;
		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		return random_int;
		
	}
}
