package payments.api.resources.mapper;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;

import org.dozer.DozerBeanMapper;

import payments.api.entity.Product;
import payments.api.entity.ProductPayment;
import payments.api.entity.User;
import payments.api.ro.ProductPaymentRO;
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
		ProductRO productRO = dozerBeanMapper.map(product, ProductRO.class);
		LocalDate localDate = LocalDate.now();
		productRO.setDueDate(localDate.withDayOfMonth(product.getPaymentDueBy()));
		return productRO;
	}

	public Product mapToProduct(ProductRO productRO) {
		return dozerBeanMapper.map(productRO, Product.class);
	}

	public ProductPaymentRO mapToProductPaymentRO(ProductPayment productPayment) {
		ProductPaymentRO productPaymentRO = new ProductPaymentRO();
		productPaymentRO.setAmount(productPayment.getAmount());
		productPaymentRO.setPaymentDate(productPayment.getPaymentDate());
		if (productPayment.getProduct() != null) {
			productPaymentRO.setProductName(productPayment.getProduct().getName());
			productPaymentRO.setProductId(productPayment.getProduct().getId());
		}

		return productPaymentRO;
	}
}
