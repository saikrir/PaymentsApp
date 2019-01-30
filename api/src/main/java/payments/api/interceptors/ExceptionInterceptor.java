package payments.api.interceptors;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import payments.api.ro.ErrorRO;

@Provider
public class ExceptionInterceptor implements ExceptionMapper<Exception> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception exception) {
	logger.error("An error has been handled ", exception);
	String message = StringUtils.defaultString(exception.getMessage(), "Generic Excpeption has occured");
	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorRO(message))
		.type(MediaType.APPLICATION_JSON).build();
    }

}
