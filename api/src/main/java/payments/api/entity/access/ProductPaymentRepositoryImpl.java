package payments.api.entity.access;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<ProductPayment> findPayments(Date after) {
        Map<String, Date> queryParam = new HashMap<>();
        queryParam.put("date", after);
        return searchByQuery(QUERY_FIND_PAYMENTS, queryParam);
    }

    @Override
    protected Class<ProductPayment> getEntityClass() {
        return ProductPayment.class;
    }

}