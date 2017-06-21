package zarc.ray;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import controller.Database;

import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.*;
 
/**
 * Jersey HTTP Basic Auth filter
 * @author Deisss (LGPLv3)
 */
@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {
    /**
     * Apply the filter : check input request, validate or not with user auth
     * @param containerRequest The request from Tomcat server
     */
    @Override
    public void filter(ContainerRequestContext containerRequest) throws WebApplicationException {
        //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // myresource/get/56bCA for example
        String path = containerRequest.getUriInfo().getPath(true);
       
        
			if(Database.doesCustomerExist(containerRequest.getHeaderString("e-mail"), containerRequest.getHeaderString("passwort"))) {
				System.out.println("Stanby");
				return;
			}
		
        //We do allow wadl to be retrieve
        if(/*(method.equals("GET") &&*/ (path.equals("application.wadl") || path.equals("login") || path.equals("registration"))) {
            return;
        }
        else {
        	try {
        	
        	String email = containerRequest.getCookies().get("E-Mail").getValue();
        	String passwort = containerRequest.getCookies().get("Passwort").getValue();
        	if(Database.doesCustomerExist(email, passwort) == true) return;
        	} catch (Exception e) {
        		throw new WebApplicationException(Status.UNAUTHORIZED);
			}
        }
        
        Map<String, javax.ws.rs.core.Cookie> cookies = containerRequest.getCookies();
        Set<String> keys = cookies.keySet();
        for(String key: keys){
            System.out.println("Value of "+key+" is: "+cookies.get(key).getValue());
        }
 
        //Get the authentification passed in HTTP headers parameters
        String auth = containerRequest.getHeaderString("authorization");
 
        //If the user does not have the right (does not provide any HTTP Basic Auth)
        if(auth == null){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
 
        //lap : loginAndPassword
        String[] lap = BasicAuth.decode(auth);
 
        //If login or password fail
        if(lap == null || lap.length != 2){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
 
        //DO YOUR DATABASE CHECK HERE (replace that line behind)...
      //  User authentificationResult =  AuthentificationThirdParty.authentification(lap[0], lap[1]);
 
        //Our system refuse login and password
   //     if(authentificationResult == null){
            throw new WebApplicationException(Status.UNAUTHORIZED);
    //    }
 
        //TODO : HERE YOU SHOULD ADD PARAMETER TO REQUEST, TO REMEMBER USER ON YOUR REST SERVICE...
 
      //  return;  */
    }
}