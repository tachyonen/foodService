package zarc.ray;

import controller.Database;
import junit.framework.TestCase;
import junit.textui.TestRunner;
import model.Restaurant;

public class CustomerServiceTest extends TestCase {

	
	public void testCustomerService() {
		CustomerService service = new CustomerService();
		Restaurant obj = service.getRestaurant(0);
		assertEquals(Database.getRestaurant(0), obj);
	}

}
