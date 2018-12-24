package payments.api.resources.mapper;

import javax.enterprise.context.ApplicationScoped;

import org.dozer.DozerBeanMapper;

import payments.api.entity.Product;
import payments.api.entity.User;
import payments.api.ro.ProductRO;
import payments.api.ro.UserRO;

@ApplicationScoped
public class PaymentsMapper {

	private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

	public User mapToUserEntity(UserRO userRO) {
		return dozerBeanMapper.map(userRO, User.class);
	}

	public UserRO mapToUserRO(User user) {
		return dozerBeanMapper.map(user, UserRO.class);
	}

	public ProductRO mapToProductRO(Product product) {
		return dozerBeanMapper.map(product, ProductRO.class);
	}

	public Product mapToProduct(ProductRO productRO) {
		return dozerBeanMapper.map(productRO, Product.class);
	}
}
