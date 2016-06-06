/*package ssdi.carrentalsystem.test.Login;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.Mockito;

import ssdi.carrentalsystem.dao.LoginDAO;
import ssdi.carrentalsystem.io.LoginIO;
import ssdi.carrentalsystem.utils.Constants;

*//**
 * 
 * @author haarthi
 *
 *//*
public class TestLoginDAO {
	
	@Test
	public void testLoginDAOForValid() throws Exception {
		LoginDAO loginDAO = new LoginDAO();
		LoginIO mockIO = Mockito.mock(LoginIO.class);
		Mockito.when(mockIO.getUserName()).thenReturn("test1@test.com");
		Mockito.when(mockIO.getPassword()).thenReturn("haarthi");
		
		assertNotNull(loginDAO.validateLoginDetails(mockIO));
	}
	
	@Test(expected=Exception.class)
	public void testLoginDAOForInvalid() throws Exception {
		LoginDAO loginDAO = new LoginDAO();
		LoginIO mockIO = Mockito.mock(LoginIO.class);
		Mockito.when(mockIO.getUserName()).thenReturn("test1@test.com");
		Mockito.when(mockIO.getPassword()).thenReturn("haarthi123");
		
		loginDAO.validateLoginDetails(mockIO);
	}
}*/