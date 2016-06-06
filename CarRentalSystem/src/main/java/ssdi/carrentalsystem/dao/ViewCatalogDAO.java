/**
 * 
 */
package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import ssdi.carrentalsystem.io.SearchCarsIO;
import ssdi.carrentalsystem.utils.DBConnectorFactory;


/**
 * @author Alapati Arun Sriram
 * 
 * Database utility class for all search queries
 *
 */
public class ViewCatalogDAO {
	
	/*
	 * Given the search string , check in database
	 */
	public static List<SearchCarsIO> getCarCatalogfromDb(List<SearchCarsIO> AdvancedSearchResults) throws Exception {
		Connection conn = null;;
		try {
			
			/* testing the connection to database */
			conn = DBConnectorFactory.getInstance().getDBConnection();
			Statement stmt = conn.createStatement();
			System.out.println("Connection established succesfully!");
		    
			/* getting the car catalog */
			String sqlquery=null,sqlselectclause=null,sqltableclause=null,sqlwhereclause=null;
			sqlselectclause="select A.car_id , make , model , type , capacity , rental_cost , insurance_cost , description,B.color_id, car_img_url , color_name";
			sqltableclause="from   car A , car_color B , color C";
			sqlwhereclause="where  A.car_id = B.car_id and B.color_id = c.color_id";
			sqlquery=sqlselectclause+" "+sqltableclause +" "+sqlwhereclause;
			
			System.out.println("search string is:"+sqlquery);
			
			/* Executing the query */
			ResultSet rs = stmt.executeQuery(sqlquery);

		    /* Processing the resultset */
		    while(rs.next()) {
		    	SearchCarsIO car = new SearchCarsIO();
                System.out.println("processing resultset");
                
		    	car.setCarid(Integer.parseInt(rs.getString(1)));
		    	car.setCarmake(rs.getString(2));
                car.setCarmodel(rs.getString(3));                
                car.setCarclass(rs.getString(4));
                car.setCarcapacity(Integer.parseInt(rs.getString(5)));
                car.setCarrentalcost(Float.parseFloat(rs.getString(6)));
                car.setCarinsurancecost(Float.parseFloat(rs.getString(7)));
                car.setCardescription(rs.getString(8));
                car.setCarcolorid(Integer.parseInt(rs.getString(9)));
                car.setCarimgpath(rs.getString(10)); 
                car.setCarcolor(rs.getString(11));                
                AdvancedSearchResults.add(car);
		    } 
		    
		    /* Sending the retrieved data back to model */
		    return AdvancedSearchResults;
		    
		} 
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(conn != null) {
				DBConnectorFactory.getInstance().closeDBConnection(conn);
			}
		}
	}
}