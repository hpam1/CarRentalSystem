package ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.io.CRSRegisterIO;
import ssdi.carrentalsystem.model.CRSRegisterModel;
import ssdi.carrentalsystem.utils.SessionVariableConstants;

/**
 * @author Vamsi Vaibhav
 * 
 * The CRSRegister Controller is invoked whenever a new user tries to an create  account in the portal. It gets the data for all the required fields from the new user registration page
 * and performs an initial validation of the input. Then it calls the model for storing the results into the database post passing all the validations prescribed in the code.
 * If the user account gets created successfully then a success message is displayed and a session is started for the user. Any error message will be redirected to RegView.jsp file
 * with appropriate error messages.
 *
 */

@WebServlet("/CRSRegisterController")
public class CRSRegisterController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
    public CRSRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRSRegisterModel model = null;
		CRSRegisterIO dto= new CRSRegisterIO();
		String error = null;
		int status1 = 0;
		int status2 = 0;
		dto.setFirstName(request.getParameter("Firstname"));
		dto.setLastName(request.getParameter("Lastname"));
		dto.setAddress1(request.getParameter("ADD1"));
		dto.setAddress2(request.getParameter("ADD2"));
		dto.setContact(request.getParameter("CON"));
		dto.setCity(request.getParameter("City"));
		dto.setState(request.getParameter("State"));
		dto.setZip(request.getParameter("ZIP"));
		dto.setDob(request.getParameter("DOB"));
		dto.setLexp(request.getParameter("LicExp"));
		dto.setLstate(request.getParameter("State1"));
		dto.setLnum(request.getParameter("LIC"));
		dto.setSsn(request.getParameter("SSNUM"));
		if (request.getParameter("PWD") != null
				&& !request.getParameter("PWD").isEmpty()
				&& request.getParameter("REPWD") != null
				&& !request.getParameter("REPWD").isEmpty()
				&& (request.getParameter("PWD").equals(request.getParameter("REPWD").toString()))) {
			dto.setPassword(request.getParameter("PWD"));
			if (request.getParameter("EMID") != null
					&& !request.getParameter("EMID").isEmpty()
					&& request.getParameter("EMID") != null
					&& !request.getParameter("EMID").isEmpty()
					&& (request.getParameter("EMID").equals(request
							.getParameter("REEID").toString()))) {
				dto.setEmail(request.getParameter("EMID"));
				model = new CRSRegisterModel();
				status1 = model.customerRegistration1(dto);
				if(status1 == 1){
					status2 = model.customerRegistration2(dto);
				}
			} else {
				error = "***E-mail Fields are not match***Please try again";
			}
		} else {
			error = "***Password Fields are not match***Please try again";
		}
		RequestDispatcher dispatcher;
		if (error != null || status2 == 0) {
			request.setAttribute("Messages", error);
			dispatcher = request.getRequestDispatcher("/RegView.jsp");
		} else {
			HttpSession session = request.getSession();
            session.setAttribute(SessionVariableConstants.USER_EMAIL, dto.getEmail());
            session.setAttribute(SessionVariableConstants.USER_ROLE, "");
            // set inactive time interval to 30 minutes.
            session.setMaxInactiveInterval(30*60);
			request.setAttribute("Messages", "Registered");
			dispatcher = request.getRequestDispatcher("/RegSuccess.jsp");
		}
		dispatcher.forward(request, response);					
	}
}