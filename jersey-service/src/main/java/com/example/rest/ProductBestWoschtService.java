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

@Path("/ProductBestWoscht")
public class ProductBestWoschtService {
	
	private final CopyOnWriteArrayList<ProductBestWoscht> pBeList = ProductListBestWoscht.getInstance();
	
	@GET
	  @Path("/all")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getAllBestWoschtProducts() {
	    return "--- Menue Best Woscht in Town ---\n"
	        + pBeList.stream()
	        .map(c -> c.toString())
	        .collect(Collectors.joining("\n"));
	  }
	
	 @POST
	 @Path("/order")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String test(){
		 return "bestellung\n";
	 }
	 
	 @POST
	 // @Path("/order")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String test2(){
		 return "ZweiterPost\n";
	 }
	 
	 
	 @GET
	  @Path("{id}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getProduct(@PathParam("id") long id) {
	    Optional<ProductBestWoscht> match
	        = pBeList.stream()
	        .filter(c -> c.getId() == id)
	        .findFirst();
	    
	    if (match.isPresent()) {
	      return "---Customer---\n" + match.get().toString();
	    } else {
	      return "Customer not found";
	    }
	  }

}
