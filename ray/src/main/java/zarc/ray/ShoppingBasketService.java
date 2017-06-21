package zarc.ray;

import javax.ws.rs.Path;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import controller.Database;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Customer;
import model.ShoppingBasket;

@Path("/shoppingbasket")
public class ShoppingBasketService {
	
	@GET
	@Path("/showbasket")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	
	public String getShoppingBasket(@CookieParam("E-Mail") String email, @CookieParam("Passwort") String passwort){
		
		Customer local = Database.getCustomer(email, passwort);
		return local.getBasket().toString();
	}
	

}
