package projectone.dao;
import java.util.List;
import java.util.Set;
import projectone.model.User;

public interface UserDao {
	List<User> getUser(int id);
	List<User> getAllUser();
	List<User> getUserByUserNameAndPassword(String user, String pass);
	boolean insertUser(User user);
	boolean deleteUser();
	boolean updateUser(User user);
}
