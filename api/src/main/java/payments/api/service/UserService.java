package payments.api.service;

import payments.api.entity.User;

public interface UserService {

	User getUser(Integer userId);

	void newUser(User user);

	User addProduct(Integer userId, Integer productId);
}
