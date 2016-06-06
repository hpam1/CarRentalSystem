package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.Statement;

import ssdi.carrentalsystem.io.CRSPaymentIO;
import ssdi.carrentalsystem.utils.DBConnectorFactory;

public class CRSPaymentDAO implements CRSPaymentDAOInterface {


	public int updateCustomerPayment(CRSPaymentIO crsPaymentIO) {
		Connection conn;
		Statement statement;
		int status = 0;
		StringBuilder query;
		try {
			query = new StringBuilder();
			query.append("insert into payment(User_Email,Card_holder_name,card_number,card_type,cvv,mm,yy,bill_amt) values('");
			query.append(crsPaymentIO.getUser());
			query.append("','");
			query.append(crsPaymentIO.getCardName());
			query.append("','");
			query.append(crsPaymentIO.getCardNum());
			query.append("','");
			query.append(crsPaymentIO.getCardType());
			query.append("','");
			query.append(crsPaymentIO.getCardCvv());
			query.append("','");
			query.append(crsPaymentIO.getCardMonth());
			query.append("','");
			query.append(crsPaymentIO.getCardYear());
			query.append("','");
			query.append(crsPaymentIO.getPrice());
			query.append("');");
			System.out.println(query);
			conn = DBConnectorFactory.getInstance().getDBConnection();
			statement = conn.createStatement();
			status = statement.executeUpdate(query.toString());
			System.out.println("Status" + status);
		} catch (Exception e) {
			e.printStackTrace();
			return status;
		}
		return status;
	}

}
