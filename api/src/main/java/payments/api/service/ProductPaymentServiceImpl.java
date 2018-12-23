package payments.api.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import payments.api.entity.Product;
import payments.api.entity.ProductPayment;
import payments.api.entity.User;
import payments.api.entity.access.ProductPaymentRepository;

/**
 * ProductPaymentServiceImpl
 */
@Stateless
@Local
@Transactional
public class ProductPaymentServiceImpl implements ProductPaymentService {

    @Inject
    ProductPaymentRepository productRepository;

    @Override
    public List<Product> getPendingPayments(String userId) {
        return productRepository.getProductsPendingPayments(Integer.valueOf(userId));
    }

    public ProductPayment makePayment(User user, Product product, BigDecimal amount) {
        ProductPayment payment = new ProductPayment();
        payment.setAmount(amount);
        payment.setUser(user);
        payment.setPaymentDate(new Date());
        payment.setPaymentTerm("MONTHLY");
        payment.setProduct(product);
        productRepository.savePayment(payment);
        return payment;
    }

}