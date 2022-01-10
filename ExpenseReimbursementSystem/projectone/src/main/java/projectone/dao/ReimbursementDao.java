package projectone.dao;

import java.util.List;

import projectone.model.Reimbursement;

public interface ReimbursementDao {
	
	List<Reimbursement> getReimbursement(int id);
	List<Reimbursement> getAllReimbursements();
	boolean insertReimbursements(Reimbursement reimbursement);
	boolean updateReimbursements(Reimbursement reimbursement);
	boolean deleteReimbursements();
}
