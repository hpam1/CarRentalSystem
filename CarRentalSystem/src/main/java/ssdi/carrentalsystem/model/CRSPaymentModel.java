package ssdi.carrentalsystem.model;

import ssdi.carrentalsystem.dao.CRSPaymentDAO;
import ssdi.carrentalsystem.dao.CRSPaymentDAOInterface;
import ssdi.carrentalsystem.io.CRSPaymentIO;

/**
 * @author Vamsi Vaibhav
 * 
 *
 */

public class CRSPaymentModel {

	public int customerPayment(CRSPaymentIO dto) {
		CRSPaymentDAOInterface crsPaymentDAOInterface = new CRSPaymentDAO();
		return crsPaymentDAOInterface.updateCustomerPayment(dto);
	}
}
