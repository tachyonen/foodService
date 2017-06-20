package model;

import org.glassfish.jersey.server.internal.RuntimeExecutorsBinder.BackgroundSchedulerLiteral;

public class Restaurant {
	
	private static long counter = 0;
	private final long id;
	private String companyName;
	private String adress;
	private String phoneNumber;
	private String eMail;
	private String passwort;
	private boolean isOpen;

	
	public Restaurant(Restaurant rest) {
		this.id = rest.id;
		this.companyName = rest.companyName;
		this.adress = rest.adress;
		this.phoneNumber = rest.phoneNumber;
		this.eMail = rest.eMail;
		this.passwort = rest.passwort;
	}
	
	public Restaurant(String companyName, String adress, String phoneNumber, String eMail, String passwort, boolean isOpen) {
		this.id = Restaurant.counter++;
		this.companyName = companyName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.passwort = passwort;
		this.isOpen = isOpen;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public long getId() {
		return id;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\n" + 
	    	       "Company Name: " + this.companyName + "\n" + 
	    	       "Adress: " + this.adress + "\n" +
	    	       "E-Mail: " + this.eMail + "\n" +
	    	       "Phone Number: " + this.phoneNumber + "\n" +
	    	       "Passwort: " + this.passwort + "\n";
	    	     
	}
	
	
}
