package controller;
import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.message.internal.MsgTraceEvent;

import model.*;
public class MessageService {

	public static List<Message> getAllMessage() {
		Message m1 = new Message("Zarc", "Zarc");
		Message m2 = new Message("Zarc", "Zarc");
		List<Message> mess = new ArrayList<>();
		mess.add(m1);
		mess.add(m2);
		return mess;
	}
}
