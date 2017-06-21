package zarc.ray;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.crypto.Data;

import controller.Database;
import model.Customer;
import model.Product;
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
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String getProductChinaRestaurant(@PathParam("id") long id){
		
		
		String a = "<form method=\"post\">";
        a += "Which product do you want to add:<br>";
        a +=  "<input type=\"text\" name=\"ProductID\"><br>";
        a += "<input type=\"submit\" value=\"Submit\">";
   	    a += "</form>";
   	    
   	    String b = "<form method=\"delete\">";
        b += "Which product do you want to remove:<br>";
        b +=  "<input type=\"text\" name=\"ProductID\"><br>";
        b += "<input type=\"submit\" value=\"Submit\">";
	    b += "</form>";
   	    
   	    return Database.getProductChinaShushi(id).toString() + "\n" + a + "\n Or do you want to remove something from basket\n\n" + b;
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
	public String addProdukt(@FormParam("ProductID") long id, @CookieParam("E-Mail") String mail, @CookieParam("Passwort") String passwort){
		
		Customer customer = Database.getCustomer(mail, passwort);
		Product x = Database.prodChinaShushi.get(id);
		customer.addProductToBasket(x);
		return "Product has been added"; 
	}
	/*POSTMAN*/
	@DELETE
	@Path("chinaSushi/{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String removeProdukt(@HeaderParam("E-Mail") String mail, @HeaderParam("Passwort") String passwort, @HeaderParam("ID") long id){
		
		Customer customer = Database.getCustomer(mail, passwort);
		Product x = Database.prodChinaShushi.get(id);
		customer.removeProductFromBasket(x);
		return "Product has been removed"; 
	}
	
	/*POSTMAN BENUTZEN*/
	@PUT
	@Path("chinaSushi/{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String removeProdukt(@HeaderParam("E-Mail") String mail, @HeaderParam("Passwort") String passwort, @HeaderParam("NewID") Long newID, @HeaderParam("OldID") Long OldID){
		
		Customer customer = Database.getCustomer(mail, passwort);
		Product x = Database.prodChinaShushi.get(OldID);
		Product y = Database.prodChinaShushi.get(newID);
		customer.changeProductsinBasket(x, y);
		return "Product has been switched"; 
	}
	

}
