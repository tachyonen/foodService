package zarc.ray;

import static org.junit.Assert.assertEquals;
import java.awt.List;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.research.ws.wadl.Request;

import controller.Database;
import junit.framework.TestCase;
import model.Product;
import model.Restaurant;

public class CustomerServiceTest extends TestCase {
	private static final int HTTP_STATUSCODE_201_RESOURCECREATED = 201;
	private static final int HTTP_STATUSCODE_204_NOCONTENT = 204;
	private static final int HTTP_STATUSCODE_200_OK = 200;
	private static final int HTTP_STATUSCODE_304_NOTMODIFIED = 304;
	private static final int HTTP_STATUSCODE_401_UNAUTHORIZED = 401;
	private static HttpServer server;
	private static WebTarget target;

	public CustomerServiceTest() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 
	 * @BeforeClass public static void setUp() throws Exeption{ server =
	 * Main.startServer(); Client c = ClientBuilder.newClient(); target =
	 * c.target(Main.BASE_URI + "restaurants"); }
	 * 
	 * @AfterClass public static void teardown() throws Exception{
	 * server.shutdown(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @After
	 * 
	 * public void cleanup(){
	 * 
	 * String encoding = encodeTestRestaurantUserCredentials();
	 * 
	 * target.request().header("Authorization", encoding).delete();
	 * 
	 * }
	 * 
	 */
	@Test
	public void testGetRestaurants() {
		/*
		 * java.util.Set<Restaurant> restaurants = null;
		 * 
		 * 
		 * 
		 * restaurants = target.request(MediaType.APPLICATION_XML).get(new
		 * GenericType<java.util.Set<Restaurant>>(){
		 * 
		 * });
		 * 
		 * assertNotNull(restaurants);
		 */
		// Hashtable<Long, Restaurant> rest = new Hashtable<>();

		CustomerService service = new CustomerService();
		Restaurant obj = new Restaurant("", "", "", "", "", true);
		Database.rest.put(obj.getId(), obj);
		assertEquals(obj, service.getRestaurant(obj.getId()));
	}

	public void testGetProductFromRestaurant() {
		/*
		 * java.util.Set<Restaurant> restaurants = null;
		 * 
		 * 
		 * 
		 * restaurants = target.request(MediaType.APPLICATION_XML).get(new
		 * GenericType<java.util.Set<Restaurant>>(){
		 * 
		 * });
		 * 
		 * assertNotNull(restaurants);
		 */
		// Hashtable<Long, Restaurant> rest = new Hashtable<>();
		CustomerService service = new CustomerService();
		Restaurant obj = new Restaurant("", "", "", "", "", true);
		Product product = new Product("Apfel", "info", 2, 2);
		obj.addProduct(product);

		Database.rest.put(obj.getId(), obj);
		assertEquals(obj.getProduct(product.getId()), service.getProductFromRestaurant(obj.getId(), product.getId()));
	}

	public void testAddProductToBasket() {

		CustomerService service = new CustomerService();
		Restaurant obj = new Restaurant("", "", "", "", "", true);
		Product product = new Product("Apfel", "info", 2, 2);
		obj.addProduct(product);
		
		Database.rest.put(obj.getId(), obj);
		String xy = service.addProductToBasket(null, obj.getId(), product.getId(), "alpha", "beta");
		assertEquals("Product has been added", xy);
	    
		
	}
}
