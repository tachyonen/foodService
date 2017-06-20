package zarc.ray;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import model.ShoppingBasket;

@Path("/shoppingbasket")
public class ShoppingBasketService {
	
	@GET
	@Path("/showbasket")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getShoppingBasket(){
		return ShoppingBasket.getProd().toString();
	}
	

}
