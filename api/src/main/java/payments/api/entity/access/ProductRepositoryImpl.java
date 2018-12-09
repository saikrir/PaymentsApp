package payments.api.entity.access;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import payments.api.entity.Product;

public class ProductRepositoryImpl extends AbstractRepository<Product> implements ProductRepository {

	@Override
	public Product saveProduct(Product product) {
		return saveEntity(product);
	}

	@Override
	public Product retrievProduct(Integer id) {
		return findById(id);
	}

	@Override
	public List<Product> searchByDueDate() {
		Map<String, Date> paramValues = new HashMap<>();
		paramValues.put("paymentDueBy", new Date());
		return searchByQuery(QUERY_BY_DUE_DATE, paramValues);
	}

	@Override
	public Product removeProduct(Integer id) {
		return removeEntity(id);
	}

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

	@Override
	public List<Product> getPendingPayments(Integer userId) {
		String query = "SELECT p from User u join u.products p where p.paymentDueBy > :paymentDueBy and u.id = :userId";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("paymentDueBy", 11);
		paramMap.put("userId", userId);
		return searchByQuery(query, paramMap);
	}
}
