package ssdi.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;
import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.dao.CarRentalDAOInterface;
import ssdi.carrentalsystem.model.CarAvailabilityModel;
import ssdi.carrentalsystem.model.CarRenewalModel;
import ssdi.carrentalsystem.utils.CarInstanceDAOFactory;
import ssdi.carrentalsystem.utils.CarLockDAOFactory;
import ssdi.carrentalsystem.utils.CarRentalDAOFactory;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.RedirectionPages;
import ssdi.carrentalsystem.utils.SessionVariableConstants;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author Haarthi
 * 
 * The CarAvailabilityChecker is invoked whenever the "Check Car availability" button is clicked. 	
 * It checks if the chosen car is available for the selected dates. If so, it returns the cost estimate
 * for the rental
 *
 */

@WebServlet(description = "Car Renewal Availability checker Servlet", 
urlPatterns = { "/CheckRenewAvailability" })
public class RenewCarChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RenewCarChecker() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startDate, endDate;
		String carRegId = "1";
		int rentalId = 1;
		HttpSession session;
		CarRenewalModel model;
		try {
			String action = request.getParameter("action");
			if(action.equals("Back to search")) {
				response.sendRedirect(RedirectionPages.VIEW_CATALOG_PAGE);
			} else {
				CarRentalDAOInterface carRentalDAO = CarRentalDAOFactory.getInstance().getCarRentalDAO(Constants.CAR_RENTAL_DAO_ACTUAL);
				CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
				session = request.getSession();
				
				model = new CarRenewalModel(carRentalDAO, carLockDAO);
				if(session.getAttribute(SessionVariableConstants.RENTAL_TRANS_ID) != null)
					rentalId = Integer.parseInt(session.getAttribute(SessionVariableConstants.RENTAL_TRANS_ID).toString());
				System.out.println(session.getAttributeNames().toString());
				endDate = request.getParameter("endDate");
				
				startDate = model.getRenewalStartDate(rentalId);
				System.out.println("INFO: inside CarAvailability checker for " + carRegId + " from " + startDate + " to: " + endDate);
				
				carRegId = model.getCarRegistrationNo(rentalId);
				
				// get car instances for the chosen car make and model and start and end dates
				if(!model.getCarAvailability(carRegId, rentalId, startDate, endDate)) {
					// no car instance available
					request.setAttribute("msg", UserMessages.NO_CAR_EXISTS);
					request.getRequestDispatcher(RedirectionPages.RENEW_COST_ESTIMATE_PAGE).forward(request, response);
				} else {
					// set the car instance list, start date, end date in session and redirected to cost estimate calculator
					session.setAttribute(SessionVariableConstants.CAR_REG_ID, carRegId);
					session.setAttribute(SessionVariableConstants.RENT_START_DATE, startDate);
					session.setAttribute(SessionVariableConstants.RENT_END_DATE, endDate);
					response.sendRedirect(RedirectionPages.RENEW_COST_ESTIMATE_CONTROLLER);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(RedirectionPages.RENEW_COST_ESTIMATE_PAGE).forward(request, response);
		}
	}
}