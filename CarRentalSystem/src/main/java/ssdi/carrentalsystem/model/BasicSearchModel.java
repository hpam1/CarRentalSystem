/**
 * 
 */
package ssdi.carrentalsystem.model;


import java.util.List;


import ssdi.carrentalsystem.dao.BasicSearchDAO;
import ssdi.carrentalsystem.io.CarsIO;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author Alapati Arun Sriram
 * 
 * The BasicSearchModel class is invoked by BasicSearchController servlet. It is provided with search string.
 * The model then invokes the database to search for the query given by the user.
 *
 */
public class BasicSearchModel {
	/*
	 * Perform a basic Search for the cars give by user.
	 * If results are found return list of carsIO objects Else throw an exception
	 * 	
	 */
	public List<CarsIO> performBasicSearch(String SearchString,String SearchField, List<CarsIO> basicSearchResults) throws Exception {
		System.out.println("Entered Basic Search model with searchtring="+SearchString);
		System.out.println("Entered Basic Search model with searchfield="+SearchField);
		basicSearchResults = BasicSearchDAO.PerformBasicCarSearch(SearchString,SearchField,basicSearchResults);
		if(basicSearchResults != null) {
			return basicSearchResults;
		} else {
			System.out.println("In else partof basic search model");
			throw new Exception(UserMessages.DATA_NOT_FOUND_IN_SEARCH);
		}
	}
}
