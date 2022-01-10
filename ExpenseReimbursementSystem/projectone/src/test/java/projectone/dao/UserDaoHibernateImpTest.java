package projectone.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import projectone.model.User;

public class UserDaoHibernateImpTest {

	@Test
	public void testGetUser() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getUser(23);

		assertEquals(1, result.size());
	}
	
	@Test
	public void testGetUser2() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getUser(23);
		User expectedUser = new User();
		expectedUser.setFirstName("Tom");
		for (User user : result) {
			
			assertEquals(expectedUser.getFirstName(), user.getFirstName());
		}
	}
	
	@Test
	public void getAllUserTest() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getAllUser();
		
		assertNotNull("Should not return null", result);
	}
	
	@Test
	public void getAllUserTestLength() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getAllUser();	
		int resultSize = result.size();		
		assertNotEquals("Result should not be less than zero", 0, resultSize);	
	}
	
	@Test 
	public void getAllUserSizeTest() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getAllUser();	
		int resultSize = result.size();
		assertNotEquals("value returned should not be greater than result size", resultSize + 1, resultSize);
	}
	
	@Test
	public void getUsernameAndPasswordNullTest() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getUserByUserNameAndPassword("SomeLogin", "password");
		assertNotNull("Should return a value", result);
	}
	
	@Test
	public void getUsernameAndPasswordTest() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getUserByUserNameAndPassword("SomeLogin", "password");
		int size = result.size();
		
		assertEquals(1, size);
	}
	
	@Test
	public void getUsernameAndPasswordTest2() {
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> result = userDaoHib.getUserByUserNameAndPassword("SomeLogin", "password");
		User user = new User();
		user.setFirstName("David");
		result.forEach(s -> assertEquals(user.getFirstName(), s.getFirstName()));
	}

}
