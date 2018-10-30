package org.sumit.zabuza.messenger.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.spi.ExceptionMappers;
import org.sumit.zabuza.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		// TODO Auto-generated method stub
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new ErrorMessage(arg0.getMessage(),500,"Zabuza"))
				.build();
	}

}
