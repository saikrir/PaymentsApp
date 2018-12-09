package payments.api.service;

import java.util.List;

import payments.api.entity.Product;

public interface ProductService {

	Product getProduct(String productId);

	Product saveProduct(Product product);

	List<Product> getProductsPendingPayment(String userId);
}
