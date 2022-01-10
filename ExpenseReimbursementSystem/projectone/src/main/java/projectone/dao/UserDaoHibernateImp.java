package projectone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import projectone.model.User;
import projectone.util.HibernateUtil;

public class UserDaoHibernateImp implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoHibernateImp.class);
	
	private User extractUser(ResultSet rs) throws SQLException {
		logger.info("Extracting user.....");
		User user = new User();

		user.setUserId(rs.getInt("userId"));
		user.setUserRole(rs.getString("userRole"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));

		return user;
	}

	// complete
	@Override
	public List<User> getUser(int id) {
		logger.info("Getting user info from database....");
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 return session.createQuery("FROM User WHERE userid =" + id, User.class).list();
			
			}
	}
	// complete
	@Override
	public List<User> getAllUser() {
		logger.info("Getting all users from database");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM User", User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getUserByUserNameAndPassword(String username, String password) {
		logger.info("Getting user when username and password matches");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from User where username='"+username+"' and password='"+password+"'", User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		logger.info("Updating user information.....");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			User updatedUser = session.load(User.class, user.getUserId());
			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setLastName(user.getLastName());;
			updatedUser.setPassword(user.getPassword());
			updatedUser.setUserName(user.getUsername());
			updatedUser.setUserId(user.getUserId());
			updatedUser.setUserRole(user.getUserRole());
			session.update(updatedUser);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
