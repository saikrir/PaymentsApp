package payments.api.interceptors;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RequestValidationInterceptor implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
	ConstraintViolationException cvExptn = (ConstraintViolationException) exception;
	List<String> collect = cvExptn.getConstraintViolations().stream().map(cve -> cve.getMessage())
		.collect(Collectors.toList());
	return Response.status(Status.BAD_REQUEST).entity(collect).build();
    }

}
