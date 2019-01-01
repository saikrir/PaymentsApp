package payments.api.ro;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;

import lombok.Data;

/**
 * ProductPaymentRO
 */

@Data
public class ProductPaymentRO {
    @Min(value = 0, message = "UserId has invalid value")
    private Integer userId;
    @Min(value = 0, message = "ProductId has invalid value")
    private Integer productId;
    @Min(value = 0, message = "Amount has to be a valid non zero value")
    private BigDecimal amount;

    private String productName;

    private Date paymentDate;
}