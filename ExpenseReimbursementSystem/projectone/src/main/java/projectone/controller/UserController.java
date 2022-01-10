package projectone.controller;

import java.util.List;
import org.apache.log4j.Logger;

import io.javalin.http.Handler;
import projectone.dao.UserDaoHibernateImp;
import projectone.model.User;

public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	static List<User> user;
	public static Handler getUsers = ctx -> {
		logger.info("Retrieves all user accounts");
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		ctx.json(userDaoHib.getAllUser());
	};

	public static Handler getSingleUser = ctx -> {
		logger.info("Retrieve a single user account");

		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		User user = ctx.bodyAsClass(User.class);
		String username = user.getUsername();
		String password = user.getPassword();
		ctx.json(userDaoHib.getUserByUserNameAndPassword(username, password));
	};

	public static Handler userLogin = ctx -> {
		logger.info("Getting user information...");
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		List<User> user = userDaoHib.getUserByUserNameAndPassword(username, password);
		User loggedUser = new User();
		for (User key : user) {
			logger.info("setting values for the logged in user...");

			loggedUser.setUserId(key.getUserId());
			loggedUser.setUserName(key.getUsername());
			loggedUser.setPassword(key.getPassword());
			loggedUser.setFirstName(key.getFirstName());
			loggedUser.setLastName(key.getLastName());
			loggedUser.setEmail(key.getEmail());
			loggedUser.setUserRole(key.getUserRole());
		}

		if (userDaoHib.getUserByUserNameAndPassword(username, password) != null) {

			logger.info("Storing values");
			// store info to use in other handlers
			ctx.cookieStore("user", loggedUser);
			ctx.cookieStore("id", loggedUser.getUserId());
			ctx.cookieStore("userRole", loggedUser.getUserRole());
		}
		if (loggedUser.getUserRole().equals("manager")) {
			logger.info("Directing user to manager page");
			ctx.redirect("./managerpage.html");
		}
		if (loggedUser.getUserRole().equals("employee")) {
			logger.info("Directing user to employee page");
			ctx.redirect("./employeepage.html");
		}
	};

	// log out and clear cookie
	public static Handler userLogout = ctx -> {
		if (ctx.body().contains("log-out")) {
			logger.info("logging out...");
			ctx.clearCookieStore();
			ctx.result("Clearing user session..");
		} else {
			logger.warn("Error occurred while logging out");
			ctx.result("log out error occured");
		}

	};

	public static Handler updateUser = ctx -> {
		logger.info("Updating user information");
		UserDaoHibernateImp userDaoHib = new UserDaoHibernateImp();
		int id = ctx.cookieStore("id");
		String userRoleStored = ctx.cookieStore("userRole");
		String email = ctx.formParam("email");
		String firstname = ctx.formParam("firstname");
		String lastname = ctx.formParam("lastname");
		String password = ctx.formParam("password");
		String username = ctx.formParam("username");
		String userRole = userRoleStored;
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPassword(password);
		user.setUserName(username);
		user.setUserId(id);
		user.setUserRole(userRole);
		userDaoHib.updateUser(user);
		
		ctx.redirect("./employeepage.html");
	};

}
