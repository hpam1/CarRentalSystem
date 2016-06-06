/**	
 * 
 */
package ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.dao.LoginDAO;
import ssdi.carrentalsystem.io.LoginIO;
import ssdi.carrentalsystem.model.LoginModel;
import ssdi.carrentalsystem.utils.RedirectionPages;
import ssdi.carrentalsystem.utils.SessionVariableConstants;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author Haarthi
 * 
 * The LoginController is called whenever a user tries to log into the system. It gets the user name and password details from the request parameters
 * and performs an initial validation of the input. Then it calls the model for login that performs the task of validating user details with the details in 
 * the database. If the user details are valid, then a session is started for the user. Any error message will be redirected to login.jsp file
 * with appropriate error messages.
 *
 */

@WebServlet(description = "Login Servlet", 
urlPatterns = { "/Login" })
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messages;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		LoginIO loginIO = null;
		LoginModel model = null;	
		LoginDAO loginDAO = null;
		String userName = null;
		try {
			userName = request.getParameter("user");
			loginIO = new LoginIO();
			loginDAO = new LoginDAO();
			model = new LoginModel();
			processRequest(request, response, loginIO, model, loginDAO);
			
		} catch(Exception e) {
			System.out.println("WARN: for " + userName + "login failed. Reason: " + messages);
			messages = e.getMessage();
			request.setAttribute("msg", messages);
			request.getRequestDispatcher(RedirectionPages.LOGIN_FAILURE_PAGE).forward(request, response);
		}
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response, LoginIO loginIO, LoginModel model, LoginDAO loginDAO)throws Exception {
		String userName = request.getParameter("user");
		String password =  request.getParameter("pwd");
		HttpSession session = null;
		loginIO.setUserName(userName);
		loginIO.setPassword(password);
		loginIO = model.validateUserDetails(loginIO, loginDAO);
		
		if(loginIO != null) {
			System.out.println("INFO: Login success for " + userName);
			session = request.getSession();
            session.setAttribute(SessionVariableConstants.USER_EMAIL, userName);
            session.setAttribute(SessionVariableConstants.USER_ROLE, loginIO.getRole());
            // set inactive time interval to 30 minutes.
            session.setMaxInactiveInterval(30*60);
            response.sendRedirect(RedirectionPages.VIEW_CATALOG_PAGE);
		} else {
			System.out.println("WARN: for " + userName + "login failed. Reason: " + messages);
			messages = UserMessages.INVALID_USER_PWD;
			request.setAttribute("msg", messages);
			request.getRequestDispatcher(RedirectionPages.LOGIN_FAILURE_PAGE).forward(request, response);
		}
	}
	
}