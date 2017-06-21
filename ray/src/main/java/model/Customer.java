package model;

public class Customer {

	private static long counter = 0;
	private final long id;
	private String firstName;
	private String lastName;
	private String Adress;
	private String phoneNumber;
	private String eMail;
	private String passwort;
	private ShoppingBasket basket;
		
	
	
	
	public Customer(String firstName, String lastName, String adress, String phoneNumber, String eMail, String passwort) {
		this.id = Customer.counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.passwort = passwort;
		this.basket = new ShoppingBasket();
	}
	
	
	
	public Customer(Customer cust) {
		this.id = cust.id;
		this.firstName = cust.firstName;
		this.lastName = cust.lastName;
		this.phoneNumber = cust.phoneNumber;
		this.eMail = cust.eMail;
		this.passwort = cust.passwort;
		this.basket = new ShoppingBasket();
	}
	
	public long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
    public String toString() {
	 
		return "ID: " + this.id + "\n" + 
    	       "First Name: " + this.firstName + "\n" + 
    	       "Last Name: " + this.lastName + "\n" +
    	       "Adress: " + this.Adress + "\n" +
    	       "Phone Number: " + this.phoneNumber + "\n" +
    	       "Email: " + this.eMail + "\n" +
    	       "Password: " + this.passwort + "\n";
    }



	public String getAdress() {
		return Adress;
	}



	public void setAdress(String adress) {
		Adress = adress;
	}



	public ShoppingBasket getBasket() {
		return basket;
	}



	public void addProductToBasket(Product product) {
		this.basket.addProductToBasket(product);
	}
	
	public void removeProductFromBasket(Product product) {
		this.basket.removeProductFromBasket(product);
	}
	
	public void changeProductsinBasket(Product product1, Product product2) {
		this.basket.changeProductsinBasket(product1, product2);
	}
}
