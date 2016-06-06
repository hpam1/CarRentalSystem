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
import ssdi.carrentalsystem.model.AdvancedSearchModel;
import ssdi.carrentalsystem.utils.UserMessages;
import ssdi.carrentalsystem.utils.RedirectionPages;


/**
 * @author Alapati Arun Sriram
 * 
 * The Basic Search Controller is triggered whenever a user performs a basic search based on car model/make/type. It gets the search category and search string details 
 * from the request parameters and performs an initial validation of the input. Then it calls the model for basic search that performs the task of searching database with 
 * the search data given by the user.If the search is successful, a list of cars satisfying user conditions will be passed to the view i.e jsp . In case search is not successful
 * no list is displayed to user.Any error message will be redirected to dbsearch.jsp 
 *
 */

@WebServlet(description = "Advanced search Servelet controller", 
urlPatterns = { "/AdvancedSearchController" })
public class AdvancedSearchController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messages=null;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{	
	   /* initialising the model and DAO objects required for search */
		List<SearchCarsIO> AdvancedSearchResults = new ArrayList<SearchCarsIO>();
		AdvancedSearchModel model = null;
		
		try {
			/* Getting the user input */
			String SearchString = request.getParameter("searchtextbox");
			String SearchField  = request.getParameter("radiobuttonchoice");
			System.out.println("Entered Basic Search controller with input string="+SearchString);
			System.out.println("Entered Basic Search controller with input option="+SearchField);
			
			/* instantiate model and pass user input to the model for validation */
			model = new AdvancedSearchModel();
			AdvancedSearchResults = model.performAdvancedSearch(SearchString,SearchField,AdvancedSearchResults);
			if(!(AdvancedSearchResults.isEmpty())) {
				System.out.println("INFO: results OK ");
				request.setAttribute("carslist", AdvancedSearchResults);
				request.setAttribute("searchcriteria",SearchField);
				request.getRequestDispatcher(RedirectionPages.ADVANCE_SEARCH_PAGE).forward(request, response);
			} 
			else {
				System.out.println("Data not found!");
				messages = UserMessages.DATA_NOT_FOUND_IN_SEARCH;
				request.setAttribute("msg", messages);
				request.getRequestDispatcher(RedirectionPages.BASIC_SEARCH_PAGE).forward(request, response);
			}
		} catch(Exception e) {
			System.out.println("In exceptions tag");
			messages = e.getMessage();
			e.printStackTrace();
			request.setAttribute("msg", messages);
			request.getRequestDispatcher(RedirectionPages.BASIC_SEARCH_PAGE).forward(request, response);
		}
	}
}