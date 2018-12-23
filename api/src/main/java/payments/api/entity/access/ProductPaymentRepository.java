package payments.api.entity.access;

import java.util.List;

import payments.api.entity.Product;
import payments.api.entity.ProductPayment;

/**
 * PaymentRepository
 */
public interface ProductPaymentRepository {

    String QUERY_FIND_PAYMENTS = "select p.* from User_Products up JOIN Product p ON up.product_id = p.id "
            + "LEFT OUTER JOIN User_Product_Payment upp ON upp.product_id="
            + "p.id where upp.payment_date IS NULL AND up.user_id=?";

    ProductPayment savePayment(ProductPayment productPayment);

    ProductPayment getProductPayment(Integer productId);

    List<Product> getProductsPendingPayments(Integer userId);

}