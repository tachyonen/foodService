package zarc.ray;

import java.util.Set;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controller.Database;

@Path("restaurant")
public class RestaurantRessource {
     String vacation = "<h1>We are on vacation that is why restaurant is closed</h1>";

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_HTML)
	public String getMessage(@PathParam("id") String id) {
	    
		String html = "<h1>Food order</h1>";
		Long x = Long.parseLong(id);
		if(Database.rest.get(x).getOpen() == false){
		return vacation + "\n" + Database.rest.get(x).toString();
		
		}
		
		return html + "\n" + Database.rest.get(x).toString();
		
	
		
	}
}
