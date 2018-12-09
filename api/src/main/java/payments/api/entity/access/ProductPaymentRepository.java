package payments.api.entity.access;

import java.util.Date;
import java.util.List;

import payments.api.entity.ProductPayment;

/**
 * PaymentRepository
 */
public interface ProductPaymentRepository {

    String QUERY_FIND_PAYMENTS = "";

    ProductPayment savePayment(ProductPayment productPayment);

    ProductPayment getProductPayment(Integer productId);

    List<ProductPayment> findPayments(Date after);

}