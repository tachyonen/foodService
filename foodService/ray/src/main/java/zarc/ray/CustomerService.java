package zarc.ray;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import controller.Database;

@Path("/restaurants")
public class CustomerService {
	
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

}
