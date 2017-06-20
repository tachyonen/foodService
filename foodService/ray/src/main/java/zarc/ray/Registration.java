package zarc.ray;

import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.spi.RegisterableService;
import javax.servlet.http.Cookie;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.crypto.Data;

import com.sun.research.ws.wadl.Request;

import controller.Database;
import model.Customer;

@Path("registration")
public class Registration {
	
	    @GET
	    @Produces(MediaType.TEXT_HTML)
	    public String enter() {
	    	 String a = "<form method=\"post\">";
	    	 a += "First Name:<br>";
	         a +=  "<input type=\"text\" name=\"First Name\"><br>";
	         a += "Last Name:<br>";
	         a +=  "<input type=\"text\" name=\"Last Name\"><br>";
	         a += "Phone Number:<br>";
	         a +=  "<input type=\"text\" name=\"Phone Number\"><br>";
	         a += "Adress:<br>";
	         a +=  "<input type=\"text\" name=\"Adress\"><br>";
	         a += "E-Mail:<br>";
	         a +=  "<input type=\"text\" name=\"E-Mail\"><br>";
	         a += "Passwort:<br>";
	         a += "<input type=\"text\" name=\"Passwort\"><br><br>";
	         a += "<input type=\"submit\" value=\"Submit\">";
	    	 a += "</form>";
	    	 return a;
	    	 }
	    
	    @POST
	    @Produces(MediaType.TEXT_HTML)
	    public Response forward(@FormParam("First Name") String firstname, @FormParam("Last Name") String lastname, 
	    		@FormParam("Phone Number") String phoneNumber, @FormParam("Adress") String adress,
	    		@FormParam("E-Mail") String email, @FormParam("Passwort") String password) throws URISyntaxException {
	    	
	    	Customer customer = new Customer(firstname, lastname, adress, phoneNumber, email, password);
	    	Database.cust.put(customer.getId(), customer);
	    	
	    	ResponseBuilder rb = Response.ok();
	    	rb.cookie(new NewCookie("E-Mail", email));
	    	rb.cookie(new NewCookie("Passwort", password));
	    	return rb.build();//.temporaryRedirect(new URI("http://localhost:8080/ray/webapi/overview")).build();
	    	
	    /* 	Response.ok().cookie(new NewCookie(email, password)).build();
			return Response
	    			.temporaryRedirect(new URI("http://localhost:8080/ray/webapi/overview")).build();*/
	    	
	    	
	    	
	    }

}
