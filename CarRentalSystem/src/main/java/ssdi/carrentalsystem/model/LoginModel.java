/**
 * 
 */
package ssdi.carrentalsystem.model;

import ssdi.carrentalsystem.dao.LoginDAO;
import ssdi.carrentalsystem.io.LoginIO;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author haarthi
 * 
 * The login Model class is invoked by loginController servlet. It is provided with user details.
 * The model then invokes the database to validate user details.
 *
 */
public class LoginModel {
	/*
	 * Validate user login details.
	 * If the user login details are true return a loginIO object with the role of the user
	 * Else throw an exception	
	 */
	public LoginIO validateUserDetails(LoginIO loginio, LoginDAO loginDAO) throws Exception {
		loginio = loginDAO.validateLoginDetails(loginio);
		if(loginio != null) {
			return loginio;
		} else {
			throw new Exception(UserMessages.INVALID_USER_PWD);
		}
	}
}