package org.sumit.zabuza.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/")
public class CommentResource {
	
	@GET
	public String test()
	{
		return "New Sub resource";
	}

	@GET
	@Path("/{commentid}")
	public String test(@PathParam("commentid") Long commendId,@PathParam("messageId") Long messageId)
	{
		return "CommentId -> "+commendId+"\nMessage ID ->"+messageId;
	}

}
