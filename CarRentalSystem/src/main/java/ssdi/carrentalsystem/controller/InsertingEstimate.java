package  ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.utils.SessionVariableConstants;

/**
 * author:mounica
 * Servlet implementation class InsertingEstimate
 */
@WebServlet("/InsertingEstimate")
public class InsertingEstimate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertingEstimate() {
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
		// TODO Auto-generated method stub
		HttpSession session;
		session = request.getSession();
		String carid;
		carid = request.getParameter("carsids");
		String hvar = request.getParameter("hvar");
		session.setAttribute(SessionVariableConstants.CAR_ID,carid);
		response.sendRedirect("CostEstimate.jsp");
		
	}

}
