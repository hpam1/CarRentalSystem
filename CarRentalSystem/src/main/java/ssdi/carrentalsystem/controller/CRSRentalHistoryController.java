package ssdi.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ssdi.carrentalsystem.dao.CRSRentalHistoryDAO;
import ssdi.carrentalsystem.model.CRSRentalHistory;
 
/**
 * @author Vamsi Vaibhav
 * Servlet implementation class Rental History 
 */
public class CRSRentalHistoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    public CRSRentalHistoryController() {
            super();
    }
 
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        String userMail;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        if(request.getSession().getAttribute("user")==null)
		{
        	userMail = "ramrock2008@gmail.com";
		}
		else
		{
			userMail = (String)request.getSession().getAttribute("user");
		}	   
        CRSRentalHistoryDAO dao = new CRSRentalHistoryDAO();
        List<CRSRentalHistory> list = dao.viewAllRentalHistory((page-1)*recordsPerPage,recordsPerPage,userMail);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("RentalList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("RentalHistory.jsp");
        view.forward(request, response);
    }
}
