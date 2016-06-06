package ssdi.carrentalsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.junit.Before;

import ssdi.carrentalsystem.io.CRSRegisterIO;
import ssdi.carrentalsystem.model.CRSRegisterModel;
import ssdi.carrentalsystem.utils.UserMessages;


/**
 * @author Vamsi Vaibhav
 *
 */

public class TestRegistration {

		CRSRegisterIO dto;
		CRSRegisterModel crsregistermodel;
		

		@Before
		public void setUp() throws Exception {
			dto = new CRSRegisterIO();
			crsregistermodel = new CRSRegisterModel();
		}

		@Test
		public void validateInsert1() {
			int status = 0; 
			try {
			dto.setFirstName("John");
			dto.setLastName("Doe");
			dto.setPassword("test@123");
			dto.setEmail("test@mail.com");
			dto.setAddress1("test street");
			dto.setAddress2("test county");
			dto.setContact("1234565678");
			dto.setCity("Charlotte");
			dto.setState("North Carolina");
			dto.setZip("28262");
			dto.setDob("1988-1-1");
			dto.setLexp("2016-12-12");
			dto.setLstate("North Carolina");
			dto.setLnum("ABDJ-256");
			dto.setSsn("111223333");
			status = crsregistermodel.customerRegistration1(dto);
			assertTrue("Success validation", status == 1);
			}
		    catch (Exception e) {
			assertEquals(UserMessages.INVALID_DATA_OR_EMAIL_ALREADY_EXIST, status == 0);
		}
		}
		
		@Test
		public void validateInsert2() {
			int status=0;
			try {
			dto.setFirstName("Chris");
			dto.setLastName("Taylor");
			dto.setPassword("mychoic@788");
			dto.setEmail("christaylor@gmail.com");
			dto.setAddress1("North trion");
			dto.setContact("4567841248");
			dto.setCity("Chicago");
			dto.setState("Illinois");
			dto.setZip("43152");
			dto.setDob("1987-12-22");
			dto.setLexp("2017-10-6");
			dto.setLstate("Illinois");
			dto.setLnum("CHTY-788");
			dto.setSsn("124343893");
			status = crsregistermodel.customerRegistration1(dto);
			assertTrue("Success validation", status == 1);
			} catch (Exception e) {
			assertEquals(UserMessages.INVALID_DATA_OR_EMAIL_ALREADY_EXIST, status == 0);
		}
		}
		
		@Test
		public void validateInsert3() {
			int status=0;
			try {
			dto.setEmail("test@mail.com");
			dto.setPassword("test@123");
			status = crsregistermodel.customerRegistration2(dto);
			assertTrue("Success validation", status == 1);
			} catch (Exception e) {
			assertEquals(UserMessages.INVALID_DATA_OR_EMAIL_ALREADY_EXIST, status == 0);
		}
	}
		
		@Test
		public void validateInsert4() {
			int status=0;
			try {
			dto.setEmail("christaylor@gmail.com");
			dto.setPassword("mychoic@788");
			status = crsregistermodel.customerRegistration2(dto);
			assertTrue("Success validation", status == 1);
		} catch (Exception e) {
			assertEquals(UserMessages.INVALID_DATA_OR_EMAIL_ALREADY_EXIST, status == 0);
	}
		}
}



