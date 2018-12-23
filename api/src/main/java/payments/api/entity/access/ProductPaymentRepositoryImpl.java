package payments.api.entity.access;

import java.util.List;

import javax.persistence.Query;

import payments.api.entity.Product;
import payments.api.entity.ProductPayment;

/**
 * ProductPaymentRepositoryImpl
 */
public class ProductPaymentRepositoryImpl extends AbstractRepository implements ProductPaymentRepository {

    @Override
    public ProductPayment savePayment(ProductPayment productPayment) {
        saveEntity(productPayment);
        getEntityManager().flush();
        return productPayment;
    }

    @Override
    public ProductPayment getProductPayment(Integer productId) {
        return (ProductPayment) findById(productId);
    }

    @Override
    public List<Product> getProductsPendingPayments(Integer userId) {
        Query pendingPaymentsQuery = getEntityManager().createNativeQuery(QUERY_FIND_PAYMENTS, Product.class);
        pendingPaymentsQuery.setParameter(1, userId);
        return pendingPaymentsQuery.getResultList();
    }

    @Override
    protected Class<ProductPayment> getEntityClass() {
        return ProductPayment.class;
    }

}