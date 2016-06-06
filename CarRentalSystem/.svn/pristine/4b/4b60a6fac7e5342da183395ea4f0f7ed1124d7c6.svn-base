package ssdi.carrentalsystem.test.mock;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ssdi.carrentalsystem.controller.CRSRentalHistoryController;

/**
 * @author Vamsi Vaibhav
 *
 */

public class CarRentalHistoryServletMock extends Mockito{
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	HttpSession session = null;
	RequestDispatcher rd = null;

	@Before
	public void setUp() throws Exception {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		rd = mock(RequestDispatcher.class);
	}

	@Test
	public void testDoGet() throws ServletException, IOException {
		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("user")).thenReturn("ramrock2008@gmail.com");
		when(request.getRequestDispatcher("RentalHistory.jsp")).thenReturn(rd);
		new CRSRentalHistoryController().doGet(request, response);
		
		verify(request.getSession(),times(2)).getAttribute("user");
		verify(rd).forward(request, response);
	}
}