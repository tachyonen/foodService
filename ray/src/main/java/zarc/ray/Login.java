package zarc.ray;

import java.awt.List;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

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

import org.glassfish.hk2.api.ValidationService;
import org.omg.PortableServer.Servant;

import com.sun.research.ws.wadl.Request;

import controller.Database;
import controller.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("login")
public class Login {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

	
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String enter(@CookieParam("E-Mail") String x) {
    	String link = "<a href=\"http://localhost:8080/ray/webapi/overview\">Link ur Startseite</a>";
    	if(x != null){return link;}
    	
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
    public Response forward(@FormParam("E-Mail") String email, @FormParam("Passwort") String passwort) throws URISyntaxException {
		return Response
    			.ok().cookie(new NewCookie("E-Mail", email)).build();
		 
    
   }
}
