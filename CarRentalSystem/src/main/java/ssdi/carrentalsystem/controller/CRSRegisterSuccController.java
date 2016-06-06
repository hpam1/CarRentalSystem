package ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ssdi.carrentalsystem.utils.RedirectionPages;

/**
 * @author Vamsi Vaibhav
 * 
 * The CRSRegister Controller is invoked by CRS Register Controller when a new user registers successfully and re-directs from RegView.jsp to Catalog JSP 
 *
 */

@WebServlet("/CRSRegisterSuccController")
public class CRSRegisterSuccController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
    public CRSRegisterSuccController() {
        super();
        // TODO Auto-generated constructor stub
    }
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			response.sendRedirect(RedirectionPages.VIEW_CATALOG_PAGE);
		}
		}
		
		
			