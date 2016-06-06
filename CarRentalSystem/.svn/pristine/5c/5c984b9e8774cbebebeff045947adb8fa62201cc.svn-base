package  ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.dao.FinalInsertCarEstimateDetailsDAO;
import ssdi.carrentalsystem.utils.RedirectionPages;

/**
 * author:mounica
 * Servlet implementation class FinalRentingCars
 */
@WebServlet("/FinalRentingCars")
public class FinalRentingCars extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FinalRentingCars() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		HttpSession session;
		session = request.getSession();
		String startDate=null;
		String endDate=null;
		String LockedCar=null;
		String user=null;
		endDate = session.getAttribute("endDate").toString();
		startDate = session.getAttribute("startDate").toString();
		LockedCar = session.getAttribute("LockedCar").toString();
		user = session.getAttribute("user").toString();
		
		System.out.println("startdate" + startDate);
		FinalInsertCarEstimateDetailsDAO.insertdetails(LockedCar,user,startDate,endDate);
		FinalInsertCarEstimateDetailsDAO.DeleteValues(LockedCar,startDate,endDate);
		RequestDispatcher dispatcher = request.getRequestDispatcher(RedirectionPages.VIEW_CATALOG_PAGE);
        dispatcher.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher(RedirectionPages.VIEW_CATALOG_PAGE);
	        dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		
		
	}

}
