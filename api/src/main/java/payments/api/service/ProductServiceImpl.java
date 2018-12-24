package payments.api.service;

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
	public Product getProduct(Integer productId) {
		return productRepo.retrievProduct(productId);
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepo.saveProduct(product);
	}

}
