package payments.api.interceptors;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@PreMatching
public class APIEndpointInterceptor implements ContainerRequestFilter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		logger.info(" [ " + requestContext.getMethod() + " ] " + requestContext.getUriInfo().getAbsolutePath());
	}

}
