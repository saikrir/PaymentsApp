package payments.api.ro;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProductRO {

	@NotEmpty(message = "Product Name is required")
	private String name;

	@Min(value = 1, message = "Invalid Day of the month")
	@Max(value = 31, message = "Invalid Day of the month")
	private Integer paymentDueBy;
}
