package payments.api.ro;

import java.math.BigDecimal;

import javax.validation.constraints.Min;

import lombok.Data;

/**
 * ProductPaymentRO
 */

@Data
public class ProductPaymentRO {
	@Min(value = 0)
	private Integer userId;
	@Min(value = 0)
	private Integer productId;
	@Min(value = 0)
	private BigDecimal amount;
}