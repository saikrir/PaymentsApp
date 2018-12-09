package payments.api.service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import payments.api.entity.Product;
import payments.api.entity.User;
import payments.api.entity.access.ProductRepository;
import payments.api.entity.access.UserRepository;

@Stateless
@Local
@Transactional
public class UserServiceImpl implements UserService {

	@Inject
	UserRepository userRepository;

	@Inject
	ProductRepository productRepo;

	@Override
	public User getUser(String userId) {
		return userRepository.retrieveUser(Integer.parseInt(userId));
	}

	@Override
	public void newUser(User user) {
		userRepository.saveUser(user);
	}

	@Override
	public User addProduct(String userId, String productId) {
		Product product = productRepo.retrievProduct(Integer.valueOf(productId));
		return userRepository.addProduct(Integer.valueOf(userId), product);
	}
}
