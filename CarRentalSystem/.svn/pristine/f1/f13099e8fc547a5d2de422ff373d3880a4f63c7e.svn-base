package ssdi.carrentalsystem.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ssdi.carrentalsystem.dao.CRSRentalHistoryDAO;
import ssdi.carrentalsystem.model.CRSRentalHistory;

/**
 * @author Vamsi Vaibhav
 *
 */

public class TestRentalHistory {

	CRSRentalHistory dto;
	CRSRentalHistoryDAO dao;

	@Before
	public void setUp() throws Exception {
		dto = new CRSRentalHistory();
		dao = new CRSRentalHistoryDAO();
	}

	@Test
	public void validateRentalStatus1() {
		boolean check = false;
		for (CRSRentalHistory dto : dao.viewAllRentalHistory(0, 5,
				"ramrock2008@gmail.com"))
			if (dto.getStatus().equals("Booked")) {
				check = true;
				break;
			}
		assertTrue("Successfull Validation", check);
	}

	@Test
	public void validateRentalStatus2() {
		boolean check = false;
		for (CRSRentalHistory dto : dao.viewAllRentalHistory(0, 20,
				"ramrock2008@gmail.com"))
			if (dto.getStatus().equals("Completed")) {
				check = true;
				break;
			}
		assertTrue("Successfull Validation", check);
	}

	@Test
	public void validateRentalStatus3() {
		boolean check = false;
		for (CRSRentalHistory dto : dao.viewAllRentalHistory(0, 20,
				"ramrock2008@gmail.com"))
			if (dto.getStatus().equals("Currently Rented")) {
				check = true;
				break;
			}
		assertTrue("Successfull Validation", check);
	}

	@Test
	public void validateuser1() {
		List<CRSRentalHistory> rentallist = dao.viewAllRentalHistory(0, 1,
				"ramrock2008@gmail.com");
		assertTrue(rentallist.size() > 0);
	}
	
	@Test
	public void validateuser2() {
		List<CRSRentalHistory> rentallist = dao.viewAllRentalHistory(0, 1,
				"abc@gmail.com");
		assertFalse(rentallist.size() > 0);
	}

}
