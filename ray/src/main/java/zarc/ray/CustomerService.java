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
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.xml.crypto.Data;

import controller.Database;
import model.Customer;
import model.Order;
import model.Product;
import model.Restaurant;
import model.ShoppingBasket;

@Path("/restaurants")
public class CustomerService {

	@GET /* Auflisten aller Restaurants in der Datenbank */
	@Path("all")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getAll() {
		return Database.rest.toString();
	}

	@GET /*
			 * Ausgabe eines bestimmten Produktes von einem bestimmten
			 * Restaurant
			 */
	@Path("{CompanyID}/{ProductID}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
	public Product getProductFromRestaurant(@PathParam("CompanyID") long CompanyID,
			@PathParam("ProductID") long ProductID) {

		Product product = Database.getRestaurant(CompanyID).getProduct(ProductID);
		return product;

	}

	@GET /* Auflistung eines bestimmten Restaurants */
	@Path("{CompanyID}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
	public Restaurant getRestaurant(@PathParam("CompanyID") long CompanyID) {

		Restaurant restaurant = Database.getRestaurant(CompanyID);
		return restaurant;

	}

	@POST /*
			 * Hinzufügen eines bestimmten Produktes vom einem bestimmten
			 * Restaurant in den Shopping basket
			 */
	@Path("{CompanyID}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String addProdukt(@Context ContainerRequestContext crc, @PathParam("CompanyID") long CompanyID,
			@HeaderParam("ProductID") long ProductID) {

		String email = (String) crc.getProperty("E-Mail");
		String passwort = (String) crc.getProperty("Passwort");
		Customer customer = Database.getCustomer(email, passwort);

		customer.addProductToBasket(Database.getRestaurant(CompanyID).getProduct(ProductID));
		return "Product has been added";
	}

	@DELETE /* Löschen eines bestimmten Produkt im Basket */
	@Path("{CompanyID}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String removeProdukt(@Context ContainerRequestContext crc, @PathParam("CompanyID") long CompanyID,
			@HeaderParam("ProductID") long ProductID) {

		String email = (String) crc.getProperty("E-Mail");
		String passwort = (String) crc.getProperty("Passwort");
		Customer customer = Database.getCustomer(email, passwort);

		customer.removeProductFromBasket(Database.getRestaurant(CompanyID).getProduct(ProductID));

		return "Product has been removed";
	}

	@PUT /* Ersetzen eines bestimmten Produkt im Basket mit einem Anderem */
	@Path("{CompanyID}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String removeProdukt(@Context ContainerRequestContext crc, @PathParam("CompanyID") Long CompanyID,
			@HeaderParam("NewProductID") Long NewProductID, @HeaderParam("OldProductID") Long OldProductID) {

		String email = (String) crc.getProperty("E-Mail");
		String passwort = (String) crc.getProperty("Passwort");
		Customer customer = Database.getCustomer(email, passwort);

		Product x = Database.getRestaurant(CompanyID).getProduct(OldProductID);
		Product y = Database.getRestaurant(CompanyID).getProduct(NewProductID);
		customer.changeProductsinBasket(x, y);
		return "Product has been switched";
	}

}
