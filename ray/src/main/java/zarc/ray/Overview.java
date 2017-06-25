package zarc.ray;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Set;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.xml.crypto.Data;

import controller.Database;
import model.Customer;
import model.Restaurant;

@Path("overview")
public class Overview {

	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getMessage(@Context ContainerRequestContext crc) {
		String email = (String) crc.getProperty("E-Mail");
		String passwort = (String) crc.getProperty("Passwort");

		Customer customer = Database.getCustomer(email, passwort);

		String html = "Hallo " + customer.getFirstName();
		String txt = new String();
		txt += "---- Restaurants in deiner Naehe -----\n";
		Set<Long> keys = Database.rest.keySet();
		for (Long key : keys) {
			txt += Database.rest.get(key).toString();
		}

		return html + "\n" + txt;
	}

	@GET
	@Path("{id}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String getOneRestaurant(@PathParam("id") long id) {
		return Database.rest.get(id).toString();
	}

	@POST
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String doPost(@Context ContainerRequestContext crc) {
		String html = "<h1>Hallo " + crc.getProperty("E-Mail") + "</h1>";
		return html;
	}

}
