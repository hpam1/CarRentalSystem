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

@WebServlet(description = "Car Availability checker Servlet", 
urlPatterns = { "/CheckAvailability" })
public class CarAvailabilityChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarAvailabilityChecker() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startDate, endDate;
		int carId = 1;
		HttpSession session;
		CarAvailabilityModel model;
		try {
			String action = request.getParameter("action");
			if(action.equals("Back to search")) {
				response.sendRedirect(RedirectionPages.VIEW_CATALOG_PAGE);
			} else {
				CarInstanceDAOInterface carInstanceDAO = CarInstanceDAOFactory.getInstance().getCarInstanceDAO(Constants.CAR_INSTANCE_DAO_ACTUAL);
				CarRentalDAOInterface carRentalDAO = CarRentalDAOFactory.getInstance().getCarRentalDAO(Constants.CAR_RENTAL_DAO_ACTUAL);
				CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
						
				model = new CarAvailabilityModel(carInstanceDAO, carRentalDAO, carLockDAO);
				startDate = request.getParameter("startDate");
				endDate = request.getParameter("endDate");
				session = request.getSession();
				if(session.getAttribute(SessionVariableConstants.CAR_ID) != null)
					carId = Integer.parseInt(session.getAttribute("carId").toString());
				System.out.println("INFO: inside CarAvailability checker for " + carId + " from: " + startDate + " to: " + endDate);
			
				// get car instances for the chosen car make and model and start and end dates
				List<String> carInstance = model.getAvailableCarInstances(carId, startDate, endDate);
				if(carInstance == null || carInstance.size() <= 0) {
					// no car instance available
					request.setAttribute("msg", UserMessages.NO_CAR_EXISTS);
					request.getRequestDispatcher(RedirectionPages.RENT_COST_ESTIMATE_PAGE).forward(request, response);
				} else {
					// set the car instance list, start date, end date in session and redirected to cost estimate calculator
					session.setAttribute(SessionVariableConstants.CAR_INSTANCE_LIST, carInstance);
					session.setAttribute(SessionVariableConstants.RENT_START_DATE, startDate);
					session.setAttribute(SessionVariableConstants.RENT_END_DATE, endDate);
					response.sendRedirect(RedirectionPages.COST_ESTIMATE_CONTROLLER);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(RedirectionPages.RENT_COST_ESTIMATE_PAGE).forward(request, response);
		}
	}
}