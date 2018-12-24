package payments.api.entity.access;

import java.util.List;

import payments.api.entity.Product;

public interface ProductRepository {

	String QUERY_BY_DUE_DATE = "SELECT p from Product p WHERE p.paymentDueBy <= :paymentDueBy";

	Product saveProduct(Product product);

	Product retrievProduct(Integer id);

	List<Product> searchByDueDate();

	Product removeProduct(Integer id);

}
