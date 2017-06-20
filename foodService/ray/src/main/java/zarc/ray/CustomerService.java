package zarc.ray;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import controller.Database;
import model.ShoppingBasket;

@Path("/restaurants")
public class CustomerService {
	
	/*@GET
	@Path("{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getProductId{@PathParam("id") long id){
		return Database.rest.get(id).toString();
	}*/
	
	
	@GET
	@Path("/all")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getAll(){
		return Database.rest.toString();
	}
	
	
	
	@GET
	@Path("chinaSushi/{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getProductChinaRestaurant(@PathParam("id") long id){
		return Database.getProductChinaShushi(id).toString();
	}
	
	
	@GET
	@Path("japanSushi/{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getProductJapanRestaurant(@PathParam("id") long id){
		return Database.getProductJapanSushi(id).toString();
	}
	
	@POST
	@Path("chinaSushi/{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String addProdukt(@PathParam("id") long id){
		ShoppingBasket shop = new ShoppingBasket();
		shop.getProd().add(Database.getProductChinaShushi(id));
		//ShoppingBasket.getProd().add();
		
		return "you have added to shopping basket";
	}

}
