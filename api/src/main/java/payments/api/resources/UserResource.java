package payments.api.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import payments.api.entity.User;
import payments.api.service.UserService;

@Path("users")
public class UserResource {

	@Inject
	UserService userService;

	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") String userId) {

		Response retVal = Response.status(Status.NOT_FOUND).build();

		User user = userService.getUser(userId);

		if (user != null) {
			retVal = Response.ok(user).build();
		}

		return retVal;
	}

	@POST
	public Response newUser(User user) {

		userService.newUser(user);

		return Response.ok().build();
	}
}
