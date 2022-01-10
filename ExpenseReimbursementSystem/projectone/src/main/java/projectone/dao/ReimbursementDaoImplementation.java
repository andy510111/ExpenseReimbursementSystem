package projectone.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projectone.model.Reimbursement;
import projectone.util.ConnectionUtil;

//public class ReimbursementDaoImplementation implements ReimbursementDao {
//	
//	//extract reimbursemennts
//	
//	private Reimbursement extractReimbursements(ResultSet rs) throws SQLException {
//		Reimbursement reimbursement = new Reimbursement();
//		
//		reimbursement.setReimbursementId(rs.getInt("reimbursementid"));
//		reimbursement.setAccepted(rs.getBoolean("accepted"));
//		reimbursement.setAmount(rs.getFloat("amount"));
//		reimbursement.setDescription(rs.getString("description"));
//		reimbursement.setReimbursementType(rs.getString("reimbursementtype"));
//		reimbursement.setResolveTime(rs.getString("resolvetime"));
//		reimbursement.setResolved(rs.getBoolean("resolved"));
//		reimbursement.setSubmitTime(rs.getString("submittime"));
//		reimbursement.setAuthorId(rs.getInt("authorid"));
//		reimbursement.setResolverId(rs.getInt("resolverid"));
//		
//		return reimbursement;
//	}
//	

//	@Override
//	public Reimbursement getReimbursement(int id) {
//		
//		try {
//			Connection conn = ConnectionUtil.getConnection();
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM reimbursement WHERE authorid =" + id);
//			
//			if (rs.next()) {
//				
//				return extractReimbursements(rs);
//			}
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

//	@Override
//	public ArrayList<Reimbursement> getAllReimbursements() {
//		try {
//			Connection conn = ConnectionUtil.getConnection();
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM reimbursement");
//			
//			ArrayList<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
//			while (rs.next()) {
//				Reimbursement reimbursement = extractReimbursements(rs);
//				reimbursementList.add(reimbursement);
//			}
//			return reimbursementList;
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public boolean insertReimbursements(Reimbursement reimbursement) {
//		try {
//			Connection conn = ConnectionUtil.getConnection();
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO reimburesment(reimbursementid, accepted, amount, description, reimbursementtype, resolvetime, resolved, submittype, authorid, resolverid) "
//					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public boolean updateReimbursements(Reimbursement reimbursement) {
//		try {
//			Connection conn = ConnectionUtil.getConnection();
//			System.out.println(reimbursement.getResolveTime());
//			PreparedStatement ps = conn.prepareStatement("UPDATE reimbursement SET accepted = ?, resolvetime= ?, resolved = ?, resolverid = ? WHERE reimbursementid = " + reimbursement.getReimbursementId());
//			ps.setBoolean(1, reimbursement.isAccepted());
//			ps.setString(2, reimbursement.getResolveTime());
//			ps.setBoolean(3, true);
//			ps.setInt(4, reimbursement.getResolverId());
//			ps.executeUpdate();
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	@Override
//	public boolean deleteReimbursements() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//}
