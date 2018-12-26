package payments.api.interceptors;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.StringUtils;

import payments.api.ro.ErrorRO;

@Provider
public class ExceptionInterceptor implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {

		Response response = null;

		if (exception instanceof ConstraintViolationException) {
			ConstraintViolationException cvExptn = (ConstraintViolationException) exception;
			List<String> collect = cvExptn.getConstraintViolations().stream().map(cve -> cve.getMessage())
					.collect(Collectors.toList());
			response = Response.status(Status.BAD_REQUEST).entity(collect).build();
		} else {
			String message = StringUtils.defaultString(exception.getMessage());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorRO(message)).build();
		}

		return response;
	}

}
