/**
 * 
 */
package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import ssdi.carrentalsystem.io.CarsIO;
import ssdi.carrentalsystem.utils.DBConnectorFactory;


/**
 * @author Alapati Arun Sriram
 * 
 * Database utility class for all search queries
 *
 */
public class BasicSearchDAO {
	
	/*
	 * Given the search string , check in database
	 */
	public static List<CarsIO> PerformBasicCarSearch(String SearchString , String SearchField, List<CarsIO> BasicSearchResults) throws Exception {
		Connection conn = null;
		try {
			
			conn = DBConnectorFactory.getInstance().getDBConnection();
			Statement stmt = conn.createStatement();
			System.out.println("Connection established succesfully!");
		    
			/* Preparing the input query based on the search choice of the user */
			String sql=null;
			if(SearchField.equals("Car Model"))
				sql="select * from car_catalogue where model='"+SearchString+"'";
			if(SearchField.equals("Car Manufacturer"))
				sql="select * from car_catalogue where make='"+SearchString+"'";
			if(SearchField.equals("Car Type"))
				sql="select * from car_catalogue where class='"+SearchString+"'";
			
			System.out.println("search string is:"+sql);
			
			/* Executing the query */
			ResultSet rs = stmt.executeQuery(sql);

		    /* Processing the resultset */
		    while(rs.next()) {
		    	CarsIO car = new CarsIO();
		    	System.out.println("processing resultset");
                
		    	car.setCarid(Integer.parseInt(rs.getString(1)));
                car.setCarmodel(rs.getString(2));                
                car.setCarmake(rs.getString(3));                
                car.setCarclass(rs.getString(4));                
                car.setCardescription(rs.getString(5));                
                car.setCarcolor(rs.getString(6));                
                car.setCarimgpath(rs.getString(7));                
                car.setCaravailablity(rs.getString(8));
                car.setCarcapacity(Integer.parseInt(rs.getString(9)));
                car.setCarrentalcost(Float.parseFloat(rs.getString(10)));
                car.setCarinsurancecost(Float.parseFloat(rs.getString(11)));
                BasicSearchResults.add(car);
		    } 
		    
		    /* Sending the retrieved data back to model */
		    return BasicSearchResults;
		    
		} 
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally {
			if(conn != null) {
				DBConnectorFactory.getInstance().closeDBConnection(conn);
			}
		}
	}
}