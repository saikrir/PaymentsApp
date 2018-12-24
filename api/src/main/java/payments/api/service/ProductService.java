package payments.api.service;

import payments.api.entity.Product;

public interface ProductService {

	Product getProduct(Integer productId);

	Product saveProduct(Product product);

}
