package com.example.rest;

import java.util.concurrent.atomic.AtomicLong;

public class Driver {
	
	private final long driverId;
	private final String driverFirstName;
	private final String driverLastName;
	private final String driverEmail;
	private final String driverAdresss;
	private final String driverPhone;
	private static final AtomicLong counter = new AtomicLong(100);
	
	
	private Driver(DriverBuilder builder){
		this.driverId = builder.driverId;
		this.driverFirstName = builder.driverFirstName;
		this.driverLastName = builder.driverLastName;
		this.driverEmail = builder.driverEmail;
		this.driverAdresss = builder.driverAdresss;
		this.driverPhone = builder.driverPhone;
	}
	
	public Driver(){
		Driver driv = new Driver.DriverBuilder().driverId().build();
		this.driverId = driv.getDriverID();
		this.driverFirstName = driv.getDriverFirstName();
		this.driverLastName = driv.getDriverLastName();
		this.driverEmail = driv.getDriverEmail();
		this.driverAdresss = driv.getDriverAdress();
		this.driverPhone = driv.getDriverPhone();
	}
	
	public Driver( long id, String firstName, String lastName, String email, 
			String adress, String phone ){
		Driver driv = new Driver.DriverBuilder().driverId()
				.driverFirstName(firstName)
				.driverLastName(lastName)
				.driverEmail(email)
				.driverAdress(adress)
				.driverPhone(phone)
				.build();
		this.driverId = driv.getDriverID();
		this.driverFirstName = driv.getDriverFirstName();
		this.driverLastName = driv.getDriverLastName();
		this.driverEmail = driv.getDriverEmail();
		this.driverAdresss = driv.getDriverAdress();
		this.driverPhone = driv.getDriverPhone();
	}
	
	public long getDriverID(){
		return this.driverId;
	}
	public String getDriverFirstName(){
		return this.driverFirstName;
	}
	public String getDriverLastName(){
		return this.driverLastName;
	}
	public String getDriverEmail(){
		return this.driverEmail;
	}
	public String getDriverAdress(){
		return this.driverAdresss;
	}
	
	public String getDriverPhone() {
		return this.driverPhone;
	}
	@Override
	public String toString(){
		return "ID: " + driverId + "\n"
				+ "First Name: " + driverFirstName + "\n"
				+ "Last Name: " + driverLastName + "\n"
				+ "Email: " + driverEmail + "\n"
				+ "Adress: " + driverAdresss + "\n"
				+ "Phone: " + driverPhone + "\n";
	}
	
	public static class DriverBuilder{
		
		private long driverId;
		private String driverFirstName = "";
		private String driverLastName = "";
		private String driverEmail = "";
		private String driverAdresss = "";
		private String driverPhone = "";
		
		
		public DriverBuilder driverId(){
			this.driverId = Driver.counter.getAndIncrement();
			return this;
		}
		
		public DriverBuilder driverId(long id){
			this.driverId = id;
			return this;
		}
		public DriverBuilder driverFirstName(String firstname){
			this.driverFirstName = firstname;
			return this;
		}
		public DriverBuilder driverLastName(String lastName){
			this.driverLastName = lastName;
			return this;
		}
		public DriverBuilder driverEmail(String email){
			this.driverEmail = email;
			return this;
		}
		public DriverBuilder driverAdress(String adress){
			this.driverAdresss = adress;
			return this;
		}
		public DriverBuilder driverPhone(String phone){
			this.driverPhone = phone;
			return this;
		}
		public Driver build(){
			return new Driver(this);
		}
	}
}
