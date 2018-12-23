package payments.api.service;

import java.math.BigDecimal;
import java.util.List;

import payments.api.entity.Product;
import payments.api.entity.ProductPayment;
import payments.api.entity.User;

/**
 * PoductPaymentService
 */
public interface ProductPaymentService {
    List<Product> getPendingPayments(String userId);

    ProductPayment makePayment(User user, Product product, BigDecimal amount);
}