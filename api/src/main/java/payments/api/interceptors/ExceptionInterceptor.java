package payments.api.interceptors;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.StringUtils;

import payments.api.ro.ErrorRO;

@Provider
public class ExceptionInterceptor implements ExceptionMapper<Exception> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception exception) {
	String message = StringUtils.defaultString(exception.getMessage());
	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorRO(message)).build();
    }

}
