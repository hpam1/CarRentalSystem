package ssdi.carrentalsystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ssdi.carrentalsystem.io.SearchCarsIO;
import ssdi.carrentalsystem.model.ViewCatalogModel;
import ssdi.carrentalsystem.utils.UserMessages;
import ssdi.carrentalsystem.utils.RedirectionPages;


/**
 * @author Alapati Arun Sriram
 * 
 * The Controller is triggered whenever successfully logins into his home page. This controller returns all the cars 
 * present in catalog to the user. Any error message will be redirected to ViewCatalog.jsp 
 *
 */

@WebServlet(description = "view catalog controller", 
urlPatterns = { "/ViewCatalogController" })
public class ViewCatalogController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messages=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<SearchCarsIO> AdvancedSearchResults = new ArrayList<SearchCarsIO>();
		ViewCatalogModel model = null;
		try {
			/* instatiate model and pass user input to the model for validation */
			model = new ViewCatalogModel();
			AdvancedSearchResults = model.getCarCatalogfrmDb(AdvancedSearchResults);
			
			/* Sending the results back to JSP page */
			if(!(AdvancedSearchResults.isEmpty())) {
				System.out.println("INFO: results OK ");
				request.setAttribute("carslist", AdvancedSearchResults);
				request.getRequestDispatcher(RedirectionPages.VIEW_CATALOG_WEBPAGE).forward(request, response);
			} 
			else {
				System.out.println("Data not found!");
				messages = UserMessages.DATA_NOT_FOUND_IN_SEARCH;
				request.setAttribute("msg", messages);
				request.getRequestDispatcher(RedirectionPages.VIEW_CATALOG_WEBPAGE).forward(request, response);
			}
		} catch(Exception e) {
			System.out.println("In excptions tag");
			messages = e.getMessage();
			e.printStackTrace();
			request.setAttribute("msg", messages);
			request.getRequestDispatcher(RedirectionPages.VIEW_CATALOG_WEBPAGE).forward(request, response);
		}
	}
}