package payments.api.ro;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * ProductPaymentRO
 */

@Data
public class ProductPaymentRO {
    @NotNull
    private String userId;
    @NotNull
    private String productId;
    @Min(value = 0)
    private BigDecimal amount;
}