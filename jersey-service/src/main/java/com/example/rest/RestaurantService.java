package com.example.rest;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/restaurants")
public class RestaurantService {
	
	private final CopyOnWriteArrayList<Restaurant> rList = RestaurantList.getInstance();
	
    static Product testProduct = new Product("testProduct", "Pizza", 0.2, 5.55, "beschreibung");
    static Restaurant testRestaurant = new Restaurant("testRestaurant", "Deutsch", "testmail");

	
	 @GET
	  @Path("/all")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getAllRestaurants() {
	    return "---Restaurant List---\n"
	        +rList.stream()
	        .map(c -> c.toString())
	        .collect(Collectors.joining("\n"));
	  }
	 
	 @GET
	  @Path("{id}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getRestaurant(@PathParam("id") long id) {
	    Optional<Restaurant> match
	        = rList.stream()
	        .filter(c -> c.getID() == id)
	        .findFirst();
	    
	    if (match.isPresent()) {
	      return "---Customer---\n" + match.get().toString() + match.get().productListToString();
	    } else {
	      return "Customer not found";
	    }
	  }
	
	 
}
