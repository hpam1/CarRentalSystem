/**
 * 
 */
package ssdi.carrentalsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ssdi.carrentalsystem.io.SearchCarsIO;
import ssdi.carrentalsystem.model.ViewCatalogModel;

/**
 * @author mounica
 *
 */


public class TestViewCatalog {
	private ViewCatalogModel catalog;
	private List<SearchCarsIO> carsList;
	
	private void iniatializeview(){
		catalog=new ViewCatalogModel();
		carsList = new ArrayList<SearchCarsIO>();
	}

	@Test
	public void testInValidViewDetails(){
		try
		{
			iniatializeview();
			carsList = catalog.getCarCatalogfrmDb(carsList);
			// currently the database has only 10 car entries.
			assertEquals(carsList.size(), 10);
		}
		catch(Exception e){
			fail("Exception thrown when valid data exists");
			e.printStackTrace();
		}
	}
}