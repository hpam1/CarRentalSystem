package  ssdi.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssdi.carrentalsystem.dao.DeleteUserDAO;
import ssdi.carrentalsystem.utils.SessionVariableConstants;

/**
 * author:mounica
 * Servlet implementation class deleteuser
 */
@WebServlet("/deleteuser")
public class deleteuserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public deleteuserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
               HttpSession session=null;
               String user=null;
try
{
		session = request.getSession();
		
		user = session.getAttribute("user").toString();
		
		DeleteUserDAO.DeleteUser(user);
		DeleteUserDAO.Deletelogindetails(user);
                response.sendRedirect("Logout");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewCatalog.jsp");
}
catch(Exception e)
{
  System.out.println("ERROR WHILE DELETING THE ACCOUNT" +e.getMessage());
  e.printStackTrace();
}
       // dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
