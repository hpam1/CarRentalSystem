/**
 * 
 */
package ssdi.carrentalsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ssdi.carrentalsystem.io.SearchCarsIO;
import ssdi.carrentalsystem.model.AdvancedSearchModel;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author mounica
 * @author Arun Sriram - updated Junit test cases for advanced search
 */

public class TestSearch
{
	private AdvancedSearchModel model;
	private List<SearchCarsIO> searchio;

	private void intializesearch() {
		model = new AdvancedSearchModel();
		searchio = new ArrayList<SearchCarsIO>();
	}
	
	@Test
	public void testValidCarModel() {
		try {
			intializesearch();
			String carModel = "i8";
			searchio = model.performAdvancedSearch(carModel, "Car Model", searchio);
			assertTrue("Success",searchio.size()>0);
		} catch(Exception e) {
			fail("Valid details but exception thrown!");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInvalidCarModel(){
		try {
			intializesearch();
			String carModel = "hello";
			searchio = model.performAdvancedSearch(carModel, "Car Model", searchio);
			assertEquals(searchio.size(), 0);
		} catch(Exception e) {
			fail("exception thrown!");
			e.printStackTrace();
		}
	}

	@Test
	public void testValidCarMfg(){
		try {
			intializesearch();
			String carMfg = "bmw";
			searchio = model.performAdvancedSearch(carMfg, "Car Manufacturer", searchio);
			assertTrue("Success",searchio.size()>0);
		} catch(Exception e) {
			fail("exception thrown!");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInvalidCarMfg(){
		try {
			intializesearch();
			String carMfg = "hello";
			searchio = model.performAdvancedSearch(carMfg, "Car Manufacturer", searchio);
			assertEquals(searchio.size(), 0);
		} catch(Exception e) {
			fail("exception thrown!");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidCarType(){
		try {
			intializesearch();
			String carType = "sports";
			searchio = model.performAdvancedSearch(carType, "Car Type", searchio);
			assertTrue("Success",searchio.size()>0);
			} catch(Exception e) {
			fail("exception thrown!");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInvalidCarType(){
		try {
			intializesearch();
			String carType = "hello";
			searchio = model.performAdvancedSearch(carType, "Car Type", searchio);
			assertEquals(searchio.size(), 0);
		} catch(Exception e) {
			fail("exception thrown!");
			e.printStackTrace();
		}
	}
}