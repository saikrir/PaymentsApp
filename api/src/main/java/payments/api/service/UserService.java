package payments.api.service;

import payments.api.entity.User;

public interface UserService {

	User getUser(String userId);

	void newUser(User user);

	User addProduct(String userId, String productId);
}
