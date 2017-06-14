package com.example.rest;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/drivers")
public class DriverService {
	
	private final CopyOnWriteArrayList<Driver> dList = DriverList.getInstance();
	
	@GET
	@Path("/all")
	@Produces(MediaType.TEXT_PLAIN)
	 public String getAllDrivers() {
	    return "---Driver List---\n\n"
	        + dList.stream()
	        .map(c -> c.toString())
	        .collect(Collectors.joining("\n"));
	  }
	
	@GET
	  @Path("{id}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getDriver(@PathParam("id") long id) {
	    Optional<Driver> match
	        = dList.stream()
	        .filter(c -> c.getDriverID() == id)
	        .findFirst();
	    
	    if (match.isPresent()) {
	      return "---Customer---\n" + match.get().toString();
	    } else {
	      return "Customer not found";
	    }
	  }	
}
