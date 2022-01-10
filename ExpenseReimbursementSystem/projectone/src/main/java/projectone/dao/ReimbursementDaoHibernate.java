package projectone.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import projectone.controller.ReimbursementController;
import projectone.model.Reimbursement;
import projectone.util.HibernateUtil;

public class ReimbursementDaoHibernate implements ReimbursementDao {

	private static final Logger logger = Logger.getLogger(ReimbursementDaoHibernate.class);
	
	@Override
	public List<Reimbursement> getReimbursement(int id) {
		logger.info("Extracting reimbursement based on id");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("From Reimbursement where reimbursementid=" + id, Reimbursement.class).list();
		}
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		logger.info("Extracting ALL reimbursements");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("From Reimbursement", Reimbursement.class).list();
		}
	}

	@Override
	public boolean insertReimbursements(Reimbursement reimbursement) {
		logger.info("Inserting new reimbursements");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			logger.info("beginning insert transaction");
			// add new reimbursement object
			reimbursement.setReimbursementId(reimbursement.getReimbursementId());
			reimbursement.setAccepted(reimbursement.isAccepted());
			reimbursement.setAmount(reimbursement.getAmount());
			reimbursement.setDescription(reimbursement.getDescription());
			reimbursement.setReimbursementType(reimbursement.getReimbursementType());
			reimbursement.setResolveTime(reimbursement.getResolveTime());
			reimbursement.setResolved(reimbursement.isResolved());
			reimbursement.setSubmitTime(reimbursement.getSubmitTime());
			reimbursement.setAuthorId(reimbursement.getAuthorId());
			
			session.save(reimbursement);
			logger.info("saving reimbursement");
			session.getTransaction().commit();
			//HibernateUtil.shutdown();
		}
		return true;
	}

	@Override
	public boolean updateReimbursements(Reimbursement reimbursement) {
		logger.info("Updating reimbursements");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			Reimbursement updateReimb = session.load(Reimbursement.class, reimbursement.getReimbursementId());
			updateReimb.setAccepted(reimbursement.isAccepted());
			updateReimb.getResolveTime();
			updateReimb.setResolved(true);
			updateReimb.setResolverId(reimbursement.getReimbursementId());
			
			session.update(updateReimb);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteReimbursements() {
		// TODO Auto-generated method stub
		return false;
	}

}
