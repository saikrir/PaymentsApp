package payments.api.resources;

import static java.util.Objects.isNull;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import payments.api.entity.User;
import payments.api.service.ProductService;
import payments.api.service.UserService;

@Path("users")
public class UserResource {

	@Inject
	UserService userService;

	@Inject
	ProductService productService;

	@Path("{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") String userId) {
		Response retVal = Response.status(Status.NOT_FOUND).build();
		User user = userService.getUser(userId);
		if (!isNull(user)) {
			retVal = Response.ok(user).build();
		}
		return retVal;
	}

	@POST
	public Response newUser(User user) {
		userService.newUser(user);
		return Response.ok(Status.ACCEPTED).build();
	}

	@PUT
	@Path("{userId}/products/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProduct(@PathParam("userId") String userId, @PathParam("productId") String productId) {
		User addProduct = userService.addProduct(userId, productId);
		return Response.status(Status.ACCEPTED).entity(addProduct).build();
	}

	@GET
	@Path("{userId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserProducts(@PathParam("userId") String userId, @QueryParam("filter") String filter) {
		Response retVal = Response.ok(productService.getProductsPendingPayment(userId)).build();
		return retVal;
	}

}
