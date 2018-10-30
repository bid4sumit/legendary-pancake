package org.sumit.zabuza.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemo {
	
	@GET
	@Path("/matrix")
	//in URL /injectdemo/annotations;param=hello
	public String getParamsUsingAnnotations(@MatrixParam("param") String param) {
		
		return "Matrix Param   -> "+param;
	}
	
	@GET
	@Path("/headerparam")
	//custom parameters present in header
	public String getHeaderPAram(@HeaderParam("name") String headerParam) {
		
		return "Header Param   -> "+headerParam;
	}

	@GET
	@Path("/context")
	//
	public String getParamsUsingContext(@Context UriInfo uri) {
		
		return " uri path "+uri.getAbsolutePath().toString();
	}


}
