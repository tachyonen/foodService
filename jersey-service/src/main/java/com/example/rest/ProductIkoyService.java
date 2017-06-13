package com.example.rest;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/ProductIkoy")
public class ProductIkoyService {
	
	private final CopyOnWriteArrayList<ProductIkoy> pIkList = ProductListIKoy.getInstance();
	
	 @GET
	  @Path("/all")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getAllIkoyProducts() {
	    return "---Restaurant List---\n"
	        + pIkList.stream()
	        .map(c -> c.toString())
	        .collect(Collectors.joining("\n"));
	  }
	 
	 
	 @POST
	 // @Path("/order")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String test(){
		 return "bestellung";
	 }
	 
	 
	 
	 @GET
	  @Path("{id}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getProduct(@PathParam("id") long id) {
	    Optional<ProductIkoy> match
	        = pIkList.stream()
	        .filter(c -> c.getId() == id)
	        .findFirst();
	    
	    if (match.isPresent()) {
	      return "---Customer---\n" + match.get().toString();
	    } else {
	      return "Customer not found";
	    }
	  }
	

}
