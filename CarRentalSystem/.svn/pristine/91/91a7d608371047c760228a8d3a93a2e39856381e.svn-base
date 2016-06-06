package ssdi.carrentalsystem.model;

import java.sql.Connection;
import java.sql.Statement;

import ssdi.carrentalsystem.io.CRSRegisterIO;
import ssdi.carrentalsystem.utils.DBConnectorFactory;

/**
 * @author Vamsi Vaibhav
 * 
 * This code has all the required functionality to insert retrieve data into the database once all the data sanity checks are completed
 *
 */


public class CRSRegisterModel {
	
	public int customerRegistration1(CRSRegisterIO dto){
		 Connection conn;
		 Statement statement;
		 int status = 0;
		 StringBuilder query;
		try{
			query = new StringBuilder();
			query.append("insert into user_details(firstname,lastname,password,emailid,address1,address2,contact,city,state,zipcode,dob,license_expiration_date,license_issued_state,license_number,ssn) values('");
			query.append(dto.getFirstName());
			query.append("','");
			query.append(dto.getLastName());
			query.append("','");
			query.append(dto.getPassword());
			query.append("','");
			query.append(dto.getEmail());
			query.append("','");
			query.append(dto.getAddress1());
			query.append("','");
			query.append(dto.getAddress2());
			query.append("','");
			query.append(dto.getContact());
			query.append("','");
			query.append(dto.getCity());
			query.append("','");
			query.append(dto.getState());
			query.append("','");
			query.append(dto.getZip());
			query.append("','");
			query.append(dto.getDob());
			query.append("','");
			query.append(dto.getLexp());
			query.append("','");
			query.append(dto.getLstate());
			query.append("','");
			query.append(dto.getLnum());
			query.append("','");
			query.append(dto.getSsn());
			query.append("');");
			System.out.println(query);
			conn = DBConnectorFactory.getInstance().getDBConnection();
			statement = conn.createStatement();
			status = statement.executeUpdate(query.toString());
			System.out.println("Status" + status);
		}catch(Exception e){
			e.printStackTrace();
			return status;
		}
		return status;
	
	
	}

		public int customerRegistration2(CRSRegisterIO dto){
		 Connection conn;
		 Statement statement;
		 int status1 = 0;
		 StringBuilder query;
		try{
			query = new StringBuilder();
			query.append("insert into login_details(username,password) values('");
			query.append(dto.getEmail());
			query.append("','");
			query.append(dto.getPassword());
			query.append("');");
			System.out.println(query);
			conn = DBConnectorFactory.getInstance().getDBConnection();
			statement = conn.createStatement();
			status1 = statement.executeUpdate(query.toString());
			System.out.println("Status" + status1);
		}catch(Exception e){
			e.printStackTrace();
			return status1;
		}
return status1;
}		
}