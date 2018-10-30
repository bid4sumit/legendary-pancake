package org.sumit.zabuza.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.sumit.zabuza.messenger.model.Message;
import org.sumit.zabuza.messenger.resources.beans.MessageFilterBean;
import org.sumit.zabuza.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	//query Param with bean annotation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean) {		
		if(messageFilterBean.getYear()>0)
		{
			return messageService.getAllMessagesforYear(messageFilterBean.getYear());
		}else if(messageFilterBean.getSize()>0&&messageFilterBean.getStart()>=0)
		{
			return messageService.getAllMessagesPaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	//query Param without bean annotation
/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,
			@QueryParam("size") int size) {		
		if(year>0)
		{
			return messageService.getAllMessagesforYear(year);
		}else if(size>0&&start>=0)
		{
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}*/
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message message(@PathParam("messageId") Long messageId)
	{
		return messageService.getMessage(messageId);
		 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message,@Context UriInfo uri) throws URISyntaxException
	{		
		Message newMessage=messageService.addMessage(message);
		URI url=uri.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		return Response.created(url)
		.status(Status.CREATED)
		.entity(newMessage)
		.build();
		//return messageService.addMessage(message);
	
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long messageId,Message message)
	{		
		message.setId(messageId);
		return messageService.updateMessage(message);
	
	
	}
	
	//@GET remove he get as you want it to happen for all methods
	@Path("/{messageId}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommentResource Comment(@PathParam("messageId") Long messageId)
	{
		return new CommentResource();
		 
	}
	
	
	

}
