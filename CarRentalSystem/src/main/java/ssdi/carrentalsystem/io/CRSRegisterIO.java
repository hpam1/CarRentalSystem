package ssdi.carrentalsystem.io;

/**
 * @author Vamsi Vaibhav
 * 
 * This code has all the required getters and setters
 *
 */

public class CRSRegisterIO  {

	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String address1;
	private String address2;
	private String contact;
	private String city;
	private String state;
	private String zip;
	private String dob;
	private String Lexp;
	private String Lstate;
	private String Lnum;
	private String ssn;

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
		/**
	 * @return the lnum
	 */
	public String getLnum() {
		return Lnum;
	}
	/**
	 * @param lnum the lnum to set
	 */
	public void setLnum(String lnum) {
		Lnum = lnum;
	}
	/**
	 * @return the lstate
	 */
	public String getLstate() {
		return Lstate;
	}
	/**
	 * @param lstate the lstate to set
	 */
	public void setLstate(String lstate) {
		Lstate = lstate;
	}
	/**
	 * @return the lexp
	 */
	public String getLexp() {
		return Lexp;
	}
	/**
	 * @param lexp the lexp to set
	 */
	public void setLexp(String lexp) {
		Lexp = lexp;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
		System.out.println(password);
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println(firstName);
				
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println(lastName);
	}
	

	}