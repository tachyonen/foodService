package zarc.ray;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Set;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import controller.Database;
import model.Restaurant;

@Path("overview")
public class Overview {
	
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String getMessage(@CookieParam("E-Mail") String value) {
		if(value == null){return "Since you are not registered you cannot see anything";}
		String html = "<h1>Hallo " + value + "</h1>";
	    String txt = new String();
		Set<Long> keys = Database.rest.keySet();
        for(Long key: keys){
          txt += Database.rest.get(key).toString();
        }

		
		return html + "\n" + txt;
	}
	@GET
	@Path("{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String getOneRestaurant(@PathParam("id") long id){
		return Database.rest.get(id).toString();
	}
	
	@POST
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String doPost(@CookieParam("E-Mail") String value) {
		String html = "<h1>Hallo " + value + "</h1>";
		return html;
	}

}
