package ssdi.carrentalsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.junit.Before;

import ssdi.carrentalsystem.io.CRSPaymentIO;
import ssdi.carrentalsystem.model.CRSPaymentModel;
import ssdi.carrentalsystem.utils.UserMessages;


/**
 * @author Vamsi Vaibhav
 *
 */

public class TestPayment {

		CRSPaymentIO dto;
		CRSPaymentModel crspaymentmodel;
	
		@Before
		public void setUp() throws Exception {
			dto = new CRSPaymentIO();
			crspaymentmodel = new CRSPaymentModel();
		}

		@Test
		public void validateInsert1() {
			int status = 0; 
			try {
			dto.setCardNum("5461794348639100");
			dto.setCardCvv("123");
			dto.setCardMonth("12");
			dto.setCardYear("15");
			dto.setCardName("John Cry");
			dto.setPrice("20");
			dto.setUser("John.Cry@gmail.com");
			dto.setCardType("Master Card");
			status = crspaymentmodel.customerPayment(dto);
			assertTrue("Success validation", status == 1);
			}
		    catch (Exception e) {
			assertEquals(UserMessages.INVALID_CARD_DETAILS, status == 0);
		}
		}
		
		@Test
		public void validateInsert2() {
			int status=0;
			try {
				dto.setCardNum("4460133476160140");
				dto.setCardCvv("354");
				dto.setCardMonth("05");
				dto.setCardYear("18");
				dto.setCardName("Paul Linen");
				dto.setPrice("55");
				dto.setUser("Paul.linen@gmail.com");
				dto.setCardType("Visa");
				status = crspaymentmodel.customerPayment(dto);	
				assertTrue("Success validation", status == 1);
			} catch (Exception e) {
			assertEquals(UserMessages.INVALID_CARD_DETAILS, status == 0);
		}
		}

		@Test
		public void validateInsert3() {
			int status = 0; 
			try {
			dto.setCardNum("5451433431114860");
			dto.setCardCvv("562");
			dto.setCardMonth("10");
			dto.setCardYear("17");
			dto.setCardName("Will Taylor");
			dto.setPrice("35");
			dto.setUser("will.taylor@gmail.com");
			dto.setCardType("Master Card");
			status = crspaymentmodel.customerPayment(dto);
			assertTrue("Success validation", status == 1);
			}
		    catch (Exception e) {
			assertEquals(UserMessages.INVALID_CARD_DETAILS, status == 0);
		}
		}
		
		@Test
		public void validateInsert4() {
			int status=0;
			try {
				dto.setCardNum("4764631478781001");
				dto.setCardCvv("113");
				dto.setCardMonth("08");
				dto.setCardYear("21");
				dto.setCardName("Justin Reynold");
				dto.setPrice("40");
				dto.setUser("justin.reynold@gmail.com");
				dto.setCardType("Visa");
				status = crspaymentmodel.customerPayment(dto);	
				assertTrue("Success validation", status == 1);
			} catch (Exception e) {
			assertEquals(UserMessages.INVALID_CARD_DETAILS, status == 0);
		}
		}

}



