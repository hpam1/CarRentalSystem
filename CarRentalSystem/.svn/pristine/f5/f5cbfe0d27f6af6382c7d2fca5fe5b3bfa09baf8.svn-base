package ssdi.carrentalsystem.controller;

/**
 * @author hpam
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.utils.RedirectionPages;
import ssdi.carrentalsystem.utils.SessionVariableConstants;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet(description = "Logout Servlet", 
urlPatterns = { "/Logout" })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session  = request.getSession();
		invalidateSession(session);
		response.sendRedirect(RedirectionPages.LOGIN_PAGE);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session  = request.getSession();
		invalidateSession(session);
		response.sendRedirect(RedirectionPages.LOGIN_PAGE);
	}
	
	private void invalidateSession(HttpSession session) {
		try {      
		    session.removeAttribute(SessionVariableConstants.USER_EMAIL);
		    session.removeAttribute(SessionVariableConstants.USER_ROLE);
		    session.invalidate();                                         
		} catch (Exception e) {
		    System.out.println("SEVERE: ERROR LOGGING USER OUT " + e.getMessage());
		    e.printStackTrace();
		}
	}
}