package zarc.ray;

import java.awt.List;
import java.awt.PageAttributes.MediaType;
import javax.ws.rs.core.*;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controller.MessageService;
import model.Message;
@Path("messages")
public class MessageResource {
	
	
	static int i = 0;
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String getMessage() {
		//return MessageService.getAllMessage();
		return "Geschafft";
	}
	
	
}
