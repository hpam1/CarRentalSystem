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
import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;
import ssdi.carrentalsystem.io.RentalCar;
import ssdi.carrentalsystem.model.RenewalEstimateModel;
import ssdi.carrentalsystem.utils.CarDAOFactory;
import ssdi.carrentalsystem.utils.CarInstanceDAOFactory;
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
@WebServlet(description = "Renewal Cost Estimator", 
urlPatterns = { "/RenewEstimator" })
public class RenewEstimator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RenewEstimator() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carRegId = "1";
		int rentalId = 1;
		HttpSession session;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		Date startDate = null, endDate = null;
		RenewalEstimateModel model = null;
		try {
			CarDAOInterface carDAO = CarDAOFactory.getInstance().getCarDAO(Constants.CARDAO_ACTUAL);
			CarInstanceDAOInterface carInstanceDAO = CarInstanceDAOFactory.getInstance().getCarInstanceDAO(Constants.CARDAO_ACTUAL);
			
			model = new RenewalEstimateModel(carDAO, carInstanceDAO);
			
			session = request.getSession();
			if(session.getAttribute(SessionVariableConstants.CAR_REG_ID) != null)
				carRegId = session.getAttribute(SessionVariableConstants.CAR_REG_ID).toString();
			if(session.getAttribute(SessionVariableConstants.RENTAL_TRANS_ID) != null)
				rentalId = Integer.parseInt(session.getAttribute(SessionVariableConstants.RENTAL_TRANS_ID).toString());
 			if(session.getAttribute(SessionVariableConstants.RENT_START_DATE) != null)
 				startDate = inputFormat.parse(session.getAttribute(SessionVariableConstants.RENT_START_DATE).toString());
			if(session.getAttribute(SessionVariableConstants.RENT_END_DATE) != null)
				endDate= formatter.parse(session.getAttribute(SessionVariableConstants.RENT_END_DATE).toString());
			// calculate cost
			RentalCar rentalCar = model.calculateCost(carRegId, startDate, endDate);
			
			String description = rentalCar.getDescription();
			Double totalCost = rentalCar.getCost();
			
			List<String> billDetails = new ArrayList(Arrays.asList(description.split("\n")));
			billDetails.add("Total Cost: $" + totalCost);
			// set the bill details in session variable
			session.setAttribute(SessionVariableConstants.BILL_LINE_DETAILS, billDetails);
			session.setAttribute(SessionVariableConstants.TOTAL_COST, totalCost);
			request.setAttribute("costEstimate", billDetails);
			request.getRequestDispatcher(RedirectionPages.RENEW_COST_ESTIMATE_PAGE).forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(RedirectionPages.RENEW_COST_ESTIMATE_PAGE).forward(request, response);
		}
	}
}