package ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import ssdi.carrentalsystem.io.CRSPaymentIO;
import ssdi.carrentalsystem.model.CRSPaymentModel;


/**
 * @author Vamsi Vaibhav
 * 
 */

@WebServlet("/CRSPaymentController")
public class CRSPaymentController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
    public CRSPaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRSPaymentModel model = null;
		CRSPaymentIO dto= new CRSPaymentIO();
		String error = null;
		int status1 = 0;
		dto.setCardNum(request.getParameter("card1")+request.getParameter("card2")+request.getParameter("card3")+request.getParameter("card4"));
		dto.setCardName(request.getParameter("cardname"));
		dto.setCardCvv(request.getParameter("cvv"));
		dto.setCardMonth(request.getParameter("expireMM"));
		dto.setCardYear(request.getParameter("expireYY"));
		dto.setCardType(request.getParameter("cardtype"));
		if(request.getSession().getAttribute("user")==null)
		{
			dto.setUser(null);
		}
		else
		{
		dto.setUser(request.getSession().getAttribute("user").toString());
		}	   
		if(request.getSession().getAttribute("TotalCost")==null)
		{
		dto.setPrice("0");
		}
		else
		{
		dto.setPrice(request.getSession().getAttribute("TotalCost").toString());
		}
		model = new CRSPaymentModel();
		status1 = model.customerPayment(dto);
				
		RequestDispatcher dispatcher;
		if (error != null || status1 == 0) {
			request.setAttribute("Messages", error);
			dispatcher = request.getRequestDispatcher("/PayView.jsp");
		} else {
            dispatcher = request.getRequestDispatcher("/PayGateway.jsp");
           }
		dispatcher.forward(request, response);					
	}
}