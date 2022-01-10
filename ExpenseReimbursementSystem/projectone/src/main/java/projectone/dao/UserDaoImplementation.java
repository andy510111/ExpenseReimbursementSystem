//package projectone.dao;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashSet;
//import java.util.Set;
//
//import projectone.model.User;
//import projectone.util.ConnectionUtil;
//
////implement userdao
//public class UserDaoImplementation implements UserDao {
//
//	private User extractUser(ResultSet rs) throws SQLException {
//		User user = new User();
//
//		user.setUserId(rs.getInt("userId"));
//		user.setUserRole(rs.getString("userRole"));
//		user.setEmail(rs.getString("email"));
//		user.setFirstName(rs.getString("firstName"));
//		user.setLastName(rs.getString("lastName"));
//		user.setUserName(rs.getString("userName"));
//		user.setPassword(rs.getString("password"));
//
//		return user;
//	}
//
////	@Override
////	public User getUser(int id) {
////
////		try {
////			Connection conn = ConnectionUtil.getConnection();
////			Statement st = conn.createStatement();
////			ResultSet rs = st.executeQuery("SELECT * FROM rmuser WHERE userid=" + id);
////
////			if (rs.next()) {
////
////				return extractUser(rs);
////			}
////		} catch (SQLException | IOException e) {
////			e.printStackTrace();
////		}
////		return null;
////
////	}
//
////	@Override
////	public Set<User> getAllUser() {
////		try {
////			Connection conn = ConnectionUtil.getConnection();
////			Statement st = conn.createStatement();
////			ResultSet rs = st.executeQuery("SELECT * FROM rmuser");
////
////			Set<User> users = new HashSet<User>();
////
////			while (rs.next()) {
////				User user = extractUser(rs);
////				users.add(user);
////			}
////			return users;
////		} catch (SQLException | IOException e) {
////			e.printStackTrace();
////		}
////		return null;
////	}
//
////	@Override
////	public User getUserByUserNameAndPassword(String username, String password) {
////		try {
////			Connection conn = ConnectionUtil.getConnection();
////			PreparedStatement ps = conn.prepareStatement("SELECT * FROM rmuser WHERE username=? AND password=?");
////			ps.setString(1, username);
////			ps.setString(2, password);
////			ResultSet rs = ps.executeQuery();
////			if (rs.next()) {
////				return extractUser(rs);
////			}
////		} catch (SQLException | IOException e) {
////			e.printStackTrace();
////		}
////
////		return null;
////	}
//
//	@Override
//	public boolean insertUser(User user) {
//		try {
//			Connection conn = ConnectionUtil.getConnection();
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO rmuser WHERE VALUES(?, ?, ?, ?, ?, ?, ?)");
//			int parameterIndex = 0;
//			ps.setInt(parameterIndex++, user.getUserId());
//			ps.setString(parameterIndex++, user.getUserRole());
//			ps.setString(parameterIndex++, user.getEmail());
//			ps.setString(parameterIndex++, user.getFirstName());
//			ps.setString(parameterIndex++, user.getLastName());
//			ps.setString(parameterIndex++, user.getUsername());
//			ps.setString(parameterIndex++, user.getPassword());
//
//			int i = ps.executeUpdate();
//
//			if (i == 1) {
//				return true;
//			}
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	@Override
//	public boolean updateUser(User user) {
//		
//		try {
//			Connection conn = ConnectionUtil.getConnection();
//			PreparedStatement ps = conn.prepareStatement("UPDATE rmuser SET email = ?, firstname = ?, lastname = ?, username = ?, password = ? WHERE userId = " + user.getUserId());;
//			ps.setString(1, user.getEmail());
//			ps.setString(2, user.getFirstName());
//			ps.setString(3, user.getLastName());
//			ps.setString(4, user.getUsername());
//			ps.setString(5, user.getPassword());
//			ps.executeUpdate();
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	@Override
//	public boolean deleteUser() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
