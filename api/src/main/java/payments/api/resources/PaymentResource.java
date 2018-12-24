package payments.api.resources;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import payments.api.entity.Product;
import payments.api.entity.ProductPayment;
import payments.api.entity.User;
import payments.api.ro.IdRO;
import payments.api.ro.ProductPaymentRO;
import payments.api.service.ProductPaymentService;
import payments.api.service.ProductService;
import payments.api.service.UserService;

/**
 * PaymentResource
 */
@Path("payments")
public class PaymentResource {

	@Inject
	ProductPaymentService productPaymentService;

	@Inject
	ProductService productService;

	@Inject
	UserService userService;

	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPendingPayments(@PathParam("id") String userId) {
		return Response.ok(productPaymentService.getPendingPayments(userId)).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newPayment(@Valid ProductPaymentRO paymentRO) {

		Integer userId = paymentRO.getUserId();
		Integer productId = paymentRO.getProductId();

		User user = userService.getUser(userId);
		Product product = productService.getProduct(productId);

		BigDecimal amount = paymentRO.getAmount();

		ProductPayment payment = productPaymentService.makePayment(user, product, amount);

		return Response.status(Status.ACCEPTED).entity(new IdRO(payment.getId())).build();
	}
}