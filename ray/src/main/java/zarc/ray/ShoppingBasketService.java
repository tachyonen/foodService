package zarc.ray;

import javax.ws.rs.Path;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;

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
	
	public String getShoppingBasket(@Context ContainerRequestContext crc){
		String email = (String) crc.getProperty("E-Mail");
		String passwort = (String) crc.getProperty("Passwort");
		
		Customer local = Database.getCustomer(email, passwort);
		return local.getBasket().toString();
	}
	

}
