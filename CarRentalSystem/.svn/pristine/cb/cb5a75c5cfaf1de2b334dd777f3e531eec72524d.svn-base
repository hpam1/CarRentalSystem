/**
 * 
 */
package ssdi.carrentalsystem.model;


import java.util.List;


import ssdi.carrentalsystem.dao.ViewCatalogDAO;
import ssdi.carrentalsystem.io.SearchCarsIO;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author Ganta Mounica
 * 
 * The View Catalog Model class is invoked by ViewCatalogController servlet.This model
 * invokes the database to get the list of all cars in catalog
 *
 */

/** update @author Arun Sriram Alapati - 
 * 
 * update in model to suit refined schema 
 * 
 * */

public class ViewCatalogModel {
	/*
	 * Retrieves a list of all cars currently in catalog 
	 * If results are found return list of SearchcarsIO objects, Else throw an exception.
	 * 	
	 */
	public List<SearchCarsIO> getCarCatalogfrmDb(List<SearchCarsIO> AdvancedSearchResults) throws Exception {
		AdvancedSearchResults = ViewCatalogDAO.getCarCatalogfromDb(AdvancedSearchResults);
		if(AdvancedSearchResults != null) {
			return AdvancedSearchResults;
		} else {
			System.out.println("In else partof view catalog model");
			throw new Exception(UserMessages.DATA_NOT_FOUND_IN_SEARCH);
		}
	}
}
