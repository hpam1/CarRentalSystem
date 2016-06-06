package ssdi.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.model.LockCarModel;
import ssdi.carrentalsystem.utils.CarLockDAOFactory;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.RedirectionPages;
import ssdi.carrentalsystem.utils.SessionVariableConstants;

/**
 * @author haarthi
 * 
 * Servlet implementation class LockCar. When the user clicks on rent button in cost estimate page
 * it will lock the car so that it is not rented to another user.
 * 
 */
@WebServlet(description = "Lock the chosen car", 
urlPatterns = { "/LockCar" })
public class LockCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LockCar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> carInstance = null;
		HttpSession session = null;
		LockCarModel model = null;
		String startDate = null;
		String endDate = null;
		String lockMech = null;
		String lockedCar = null;
		try {
			session = request.getSession();
			CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
			model = new LockCarModel(carLockDAO);
			lockMech = request.getParameter("LockCarMech");
			System.out.println(lockMech);
			if(lockMech.equals("rental")) {
				if(session.getAttribute("CarInstances") != null)
					carInstance = (List<String>) session.getAttribute("CarInstances");
				if(session.getAttribute("startDate") != null)
					startDate = session.getAttribute("startDate").toString();
				if(session.getAttribute("endDate") != null)
					endDate = session.getAttribute("endDate").toString();
				// get the locked car registration no
				lockedCar = model.lockCar(carInstance, startDate, endDate);
				session.removeAttribute(SessionVariableConstants.CAR_INSTANCE_LIST);
			} else {
				lockedCar = session.getAttribute(SessionVariableConstants.CAR_REG_ID).toString();
				if(session.getAttribute("startDate") != null)
					startDate = session.getAttribute("startDate").toString();
				if(session.getAttribute("endDate") != null)
					endDate = session.getAttribute("endDate").toString();
				model.lockCar(lockedCar, startDate, endDate);
			}
			// set the values in session
			session.setAttribute(SessionVariableConstants.RENTED_CAR, lockedCar);
			response.sendRedirect(RedirectionPages.PAYMENT_PAGE);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(RedirectionPages.RENT_COST_ESTIMATE_PAGE).forward(request, response);
		}
	}
}