package payments.api.service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import payments.api.entity.Product;
import payments.api.entity.User;
import payments.api.entity.access.ProductRepository;
import payments.api.entity.access.UserRepository;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepo;

    @Override
    public User getUser(Integer userId) {
	return userRepository.retrieveUser(userId);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void newUser(User user) {
	userRepository.saveUser(user);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public User addProduct(Integer userId, Integer productId) {
	Product product = productRepo.retrievProduct(productId);
	return userRepository.addProduct(userId, product);
    }
}
