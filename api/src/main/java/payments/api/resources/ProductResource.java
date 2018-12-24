package payments.api.resources;

import java.util.Objects;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
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
import payments.api.resources.mapper.PaymentsMapper;
import payments.api.ro.ProductRO;
import payments.api.service.ProductService;

@Path("products")
public class ProductResource {

	@Inject
	ProductService productService;
	@Inject
	PaymentsMapper paymentsMapper;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("id") @Min(value = 0) Integer productId) {
		Product product = productService.getProduct(productId);
		if (Objects.isNull(product)) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(product).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveProduct(@Valid ProductRO productRO) {
		return Response.ok(productService.saveProduct(paymentsMapper.mapToProduct(productRO))).status(Status.CREATED)
				.build();
	}
}
