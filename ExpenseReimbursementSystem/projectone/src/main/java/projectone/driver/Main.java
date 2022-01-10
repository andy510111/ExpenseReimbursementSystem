package projectone.driver;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.staticfiles.Location;
import projectone.controller.ReimbursementController;
import projectone.controller.UserController;
import projectone.dao.UserDaoHibernateImp;
import projectone.model.User;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		final Logger logger = Logger.getLogger(Main.class);
		Javalin app = Javalin.create(ctx -> {
			logger.info("Starting on local host 8501");
			ctx.enableCorsForAllOrigins();
			ctx.addStaticFiles("web", Location.CLASSPATH);
		}).start(8501);
		
		// get all reimbursments
		app.get("/reimbursement", ReimbursementController.getReimbursements);
		
		// insert reimbursement when user adds a form
		app.post("/reimbursement", ReimbursementController.insertReimbursements);
		
		// get all users
		app.get("/users", UserController.getUsers);
		
	
		//app.get("/login", UserController.getSingleUser);
		
		// logs user in
		app.post("/login", UserController.userLogin);
		
		// process stored info and send to client
		app.get("/login", ctx -> {
			ctx.json(ctx.cookieStore("user"));
		});
		
		// on logout clear current session
		app.post("/logout", UserController.userLogout);
		
		//update user information
		app.post("/update", UserController.updateUser);
		
		app.post("/pendingForms", ReimbursementController.approveOrDeny);
	}

}
