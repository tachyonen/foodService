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

import com.sun.research.ws.wadl.Request;

@Path("registration")
public class Registration {
	
	    @GET
	    @Produces(MediaType.TEXT_HTML)
	    public String enter() {
	    	 String a = "<form method=\"post\">";
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
	    public Response forward(@FormParam("E-Mail") String email, @FormParam("Passwort") String passwort) throws URISyntaxException {
	    	Response.ok().cookie(new NewCookie(email, passwort)).build();
			return Response
	    			.temporaryRedirect(new URI("http://localhost:8080/ray/webapi/overview")).build();
	    }

}
