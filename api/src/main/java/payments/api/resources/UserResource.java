package payments.api.resources;

import static java.util.Objects.isNull;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import payments.api.entity.User;
import payments.api.resources.mapper.PaymentsMapper;
import payments.api.ro.IdRO;
import payments.api.ro.UserRO;
import payments.api.service.ProductService;
import payments.api.service.UserService;

@Path("users")
public class UserResource {

	@Inject
	UserService userService;

	@Inject
	ProductService productService;

	@Inject
	PaymentsMapper paymentsMapper;

	@Path("{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") @Min(value = 0) Integer userId) {
		Response retVal = Response.status(Status.NOT_FOUND).build();
		User user = userService.getUser(userId);
		if (!isNull(user)) {
			retVal = Response.ok(paymentsMapper.mapToUserRO(user)).build();
		}
		return retVal;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newUser(@Valid UserRO userRO) {
		User user = paymentsMapper.mapToUserEntity(userRO);
		userService.newUser(user);
		return Response.ok(Status.ACCEPTED).entity(new IdRO(user.getId())).build();
	}

	@PUT
	@Path("{userId}/products/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProduct(@PathParam("userId") Integer userId, @PathParam("productId") Integer productId) {
		User updatedUser = userService.addProduct(userId, productId);
		return Response.status(Status.ACCEPTED).entity(paymentsMapper.mapToUserRO(updatedUser)).build();
	}

}
