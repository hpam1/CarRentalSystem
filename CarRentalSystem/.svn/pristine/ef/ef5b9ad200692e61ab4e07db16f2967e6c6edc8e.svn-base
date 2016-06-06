package ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.utils.RedirectionPages;
import ssdi.carrentalsystem.utils.SessionVariableConstants;

/**
 * Servlet implementation class CRSRenew
 */
public class CRSRenew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRSRenew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String renewId = request.getParameter("Renew").toString();
		HttpSession session = request.getSession();
		session.setAttribute(SessionVariableConstants.RENTAL_TRANS_ID,renewId);
		RequestDispatcher dispatcher = request.getRequestDispatcher(RedirectionPages.RENEW_COST_ESTIMATE_PAGE);
		dispatcher.forward(request, response);
	}
}