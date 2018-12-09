package payments.api.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import payments.api.entity.Product;
import payments.api.entity.access.ProductRepository;

@Stateless
@Local
@Transactional
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductRepository productRepo;

	@Override
	public Product getProduct(String productId) {
		return productRepo.retrievProduct(Integer.valueOf(productId));
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepo.saveProduct(product);
	}

	@Override
	public List<Product> getProductsPendingPayment(String userId) {
		return productRepo.getPendingPayments(Integer.valueOf(userId));
	}
}
