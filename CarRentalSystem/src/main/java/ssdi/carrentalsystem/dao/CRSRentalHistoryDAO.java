package ssdi.carrentalsystem.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import ssdi.carrentalsystem.utils.DBConnectorFactory;
import ssdi.carrentalsystem.model.CRSRentalHistory;
 
/**
 * @author Vamsi Vaibhav 
 */

public class CRSRentalHistoryDAO {
    Connection conn;
    Statement stmt;
    private int noOfRecords;
         
    public CRSRentalHistoryDAO() { }
     
    private static Connection getDBConnection() 
            throws Exception, 
                ClassNotFoundException 
    {
        Connection conn = DBConnectorFactory.
        		getInstance().getDBConnection();
        return conn;
    }
    
    
   
   
    public List<CRSRentalHistory> viewAllRentalHistory(
                int offset, 
                int noOfRecords, 
                String userMail
                ) 
       {
        String query = "select SQL_CALC_FOUND_ROWS * from car_rental_history_vw where user_email="+"'"+userMail+"'"+" "+"limit "
                 + offset + ", " + noOfRecords;
        List<CRSRentalHistory> list = new ArrayList<CRSRentalHistory>();
        CRSRentalHistory RentalHistory = null;
        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	RentalHistory = new CRSRentalHistory();
            	RentalHistory.setTransactionId(rs.getInt("rental_id"));
            	RentalHistory.setCarLicenseNo(rs.getString("car_license_no"));
            	RentalHistory.setStartDateTime(rs.getString("start_time"));
            	RentalHistory.setEndDateTime(rs.getString("end_time"));
            	RentalHistory.setUser(rs.getString("user_email"));
            	RentalHistory.setStatus(rs.getString("status"));
            	RentalHistory.setStatusLabel(rs.getString("status_label"));
            	RentalHistory.setRenew(rs.getString("renew"));
            	RentalHistory.setReservedDate(rs.getString("reserved_date"));
            	list.add(RentalHistory);
            }
            rs.close();
             
            rs = stmt.executeQuery("SELECT FOUND_ROWS()");
            if(rs.next())
                this.noOfRecords = rs.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}finally
        {
            try {
                if(stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
                } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
 
    public int getNoOfRecords() {
        return noOfRecords;
    }
}