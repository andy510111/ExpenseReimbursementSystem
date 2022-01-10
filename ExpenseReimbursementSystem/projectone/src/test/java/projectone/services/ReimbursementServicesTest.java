package projectone.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReimbursementServicesTest {

	@Test
	public void generateRandomNumTest() {
		
		
		assertNotNull(ReimbursementServices.generateRandomNum());
	}
	
	@Test
	public void generateRandomNumTest2() {
		
		assertNotEquals(0, ReimbursementServices.generateRandomNum());
	}
	
	@Test
	public void notLessThanZero() {
		assertTrue("random number should be greater than zero", (ReimbursementServices.generateRandomNum() > 0));
	}

}
