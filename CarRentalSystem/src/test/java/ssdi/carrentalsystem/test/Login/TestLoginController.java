/**
 * 
 *//*
package ssdi.carrentalsystem.test.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import ssdi.carrentalsystem.controller.LoginController;
import ssdi.carrentalsystem.dao.LoginDAO;
import ssdi.carrentalsystem.io.LoginIO;
import ssdi.carrentalsystem.model.LoginModel;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.RedirectionPages;
import ssdi.carrentalsystem.utils.SessionVariableConstants;
import ssdi.carrentalsystem.utils.UserMessages;

*//**
 * @author haarthi
 *
 *//*
public class TestLoginController {

	@Test
	public void testForValid() throws Exception {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
		LoginIO loginIO = Mockito.mock(LoginIO.class);
		LoginDAO loginDAO = Mockito.mock(LoginDAO.class);
		LoginModel model = Mockito.mock(LoginModel.class);
		
		Mockito.when(request.getParameter("user")).thenReturn("test1@test.com");
		Mockito.when(request.getParameter("pwd")).thenReturn("passw0rd");
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(request.getRequestDispatcher(RedirectionPages.LOGIN_FAILURE_PAGE)).thenReturn(rd);
		Mockito.when(loginDAO.validateLoginDetails(loginIO)).thenReturn(loginIO);
		Mockito.when(model.validateUserDetails(loginIO, loginDAO)).thenReturn(null);
		
		new LoginController().processRequest(request, response, loginIO, model, loginDAO);
		System.out.println(session);
		// Verify the session attribute value
		Mockito.verify(session).setAttribute(SessionVariableConstants.USER_EMAIL, "test1@test.com");
		Mockito.verify(session).setAttribute(SessionVariableConstants.USER_EMAIL, "test1@test.com");
		Mockito.verify(response).sendRedirect(RedirectionPages.VIEW_CATALOG_PAGE);
	}
	
	@Test
	public void testForInValid() throws Exception {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
		LoginIO loginIO = Mockito.mock(LoginIO.class);
		LoginDAO loginDAO = Mockito.mock(LoginDAO.class);
		LoginModel model = Mockito.mock(LoginModel.class);
		
		Mockito.when(request.getParameter("user")).thenReturn("test1@test.com");
		Mockito.when(request.getParameter("pwd")).thenReturn("passw0rd");
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(request.getRequestDispatcher(RedirectionPages.LOGIN_FAILURE_PAGE)).thenReturn(rd);
		Mockito.when(model.validateUserDetails(loginIO, loginDAO)).thenReturn(null);
		
		new LoginController().doPost(request, response);

		// Verify the session attribute value
		Mockito.verify(request).setAttribute("msg", UserMessages.INVALID_USER_PWD);
		Mockito.verify(request).getRequestDispatcher(RedirectionPages.LOGIN_FAILURE_PAGE);	
	}
}*/