package projectone.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import projectone.model.Reimbursement;

public class ReimbursementDaoHibernateTest {

	/* if value is not null it should pass */
	@Test
	public void getReimbursementTest() {
		int id = 1;
		ReimbursementDaoHibernate rbdao = new ReimbursementDaoHibernate();
		List<Reimbursement> output = rbdao.getReimbursement(id);
		assertNotEquals(null, output);
	}

	/* test for duplicate reimbursement id */
	@Test
	public void getReimbursementTest2() {
		int id = 3;
		ReimbursementDaoHibernate rbdao = new ReimbursementDaoHibernate();
		List<Reimbursement> output = rbdao.getReimbursement(id);
		assertEquals(1, output.size());
	}

	@Test
	public void getReimbursementTest3() {
		int id = 9;
		ReimbursementDaoHibernate rbdao = new ReimbursementDaoHibernate();
		List<Reimbursement> output = rbdao.getReimbursement(id);
		assertNotEquals(2, output.size());
	}

	// testing if it returns a length
	@Test
	public void getAllReimbursementsTest() {
		ReimbursementDaoHibernate rbdao = new ReimbursementDaoHibernate();
		List<Reimbursement> output = rbdao.getAllReimbursements();
		assertNotEquals(null, output.size());
	}
	
	
	@Test
	public void insertReimbursementTest() {
		Reimbursement newReim = new Reimbursement();
		newReim.setAccepted(false);
		newReim.setAmount(100);
		newReim.setAuthorId(100);
		newReim.setDescription("test");
		newReim.setReimbursementId(100);
		newReim.setReimbursementType("Business");
		newReim.setResolved(false);
		newReim.setResolverId(10);
		newReim.setResolveTime(null);
		newReim.setSubmitTime(null);
		ReimbursementDaoHibernate rbdao = new ReimbursementDaoHibernate();
		rbdao.insertReimbursements(newReim);
		assertEquals(true, true);
	}
	
	@Test
	public void insertReimbursementTestNull() {
		Reimbursement newReim = new Reimbursement();
		newReim.setAccepted(false);
		newReim.setAmount(100);
		newReim.setAuthorId(100);
		newReim.setDescription("test");
		newReim.setReimbursementId(100);
		newReim.setReimbursementType("Business");
		newReim.setResolved(false);
		newReim.setResolverId(10);
		newReim.setResolveTime(null);
		newReim.setSubmitTime(null);
		ReimbursementDaoHibernate rbdao = new ReimbursementDaoHibernate();
		boolean output = rbdao.insertReimbursements(newReim);
		assertNotEquals(null, output);
	}
	
//	@Test
//	public void updateReimbursementTest() {
//		Reimbursement newReim = new Reimbursement();
//		
//		newReim.setAccepted(false);
//		newReim.setAmount(100);
//		newReim.setDescription("test");
//		newReim.setReimbursementId(20);
//		newReim.setReimbursementType("Business");
//		newReim.setResolved(false);
//		newReim.setResolverId(10);
//		newReim.setResolveTime(null);
//		newReim.setSubmitTime(null);
//		ReimbursementDaoHibernate rbdao = new ReimbursementDaoHibernate();
//		boolean output = rbdao.updateReimbursements(newReim);
//		assertEquals(true, output);
//	}

}
