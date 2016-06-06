package ssdi.carrentalsystem.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.dao.CarDAOInterface;
import ssdi.carrentalsystem.io.RentalCar;
import ssdi.carrentalsystem.model.CostEstimateModel;
import ssdi.carrentalsystem.utils.CarDAOFactory;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.RedirectionPages;
import ssdi.carrentalsystem.utils.SessionVariableConstants;

/**
 * 
 * @author haarthi
 * Calculate the cost for the chosen car for the selected rental period.
 * The cost calculator uses a decorator pattern for calculating the different costs
 *
 */
@WebServlet(description = "Cost Estimator", 
urlPatterns = { "/CostEstimator" })
public class CostEstimator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CostEstimator() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int carId = 1;
		HttpSession session;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date startDate = null, endDate = null;
		CostEstimateModel model = null;
		try {
			CarDAOInterface carDAO = CarDAOFactory.getInstance().getCarDAO(Constants.CARDAO_ACTUAL);
			model = new CostEstimateModel(carDAO);
			
			session = request.getSession();
			if(session.getAttribute(SessionVariableConstants.CAR_ID) != null)
				carId = Integer.parseInt(session.getAttribute(SessionVariableConstants.CAR_ID).toString());
			if(session.getAttribute(SessionVariableConstants.RENT_START_DATE) != null)
				startDate = formatter.parse(session.getAttribute(SessionVariableConstants.RENT_START_DATE).toString());
			if(session.getAttribute(SessionVariableConstants.RENT_END_DATE) != null)
				endDate= formatter.parse(session.getAttribute(SessionVariableConstants.RENT_END_DATE).toString());
			// calculate cost
			RentalCar rentalCar = model.calculateCost(carId, startDate, endDate);
			
			String description = rentalCar.getDescription();
			Double totalCost = rentalCar.getCost();
			
			List<String> billDetails = new ArrayList(Arrays.asList(description.split("\n")));
			billDetails.add("Total Cost: $" + totalCost);
			// set the bill details in session variable
			session.setAttribute(SessionVariableConstants.BILL_LINE_DETAILS, billDetails);
			session.setAttribute(SessionVariableConstants.TOTAL_COST, totalCost);
			request.setAttribute("costEstimate", billDetails);
			request.getRequestDispatcher(RedirectionPages.RENT_COST_ESTIMATE_PAGE).forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(RedirectionPages.RENT_COST_ESTIMATE_PAGE).forward(request, response);
		}
	}
}