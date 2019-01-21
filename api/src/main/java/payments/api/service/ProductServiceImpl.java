package payments.api.service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import payments.api.entity.Product;
import payments.api.entity.access.ProductRepository;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductRepository productRepo;

    @Override
    public Product getProduct(Integer productId) {
	return productRepo.retrievProduct(productId);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Product saveProduct(Product product) {
	return productRepo.saveProduct(product);
    }

}
