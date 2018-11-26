package payments.api.resources;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import payments.api.entity.User;

@Path("users")
public class UserResource {

	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(String userId) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		User user = new User();
		user.setEmailId("rao.saikrishna@gmail.com");
		user.setName("Todd Terje");

		builder.add("name", user.getName());
		builder.add("emailId", user.getEmailId());

		JsonObject build = builder.build();
		return Response.ok(build).build();
	}
}
