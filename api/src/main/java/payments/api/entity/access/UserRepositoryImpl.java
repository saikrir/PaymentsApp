package payments.api.entity.access;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import payments.api.entity.Product;
import payments.api.entity.User;

@RequestScoped
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

	@Override
	public User saveUser(User user) {
		return saveEntity(user);
	}

	@Override
	public User retrieveUser(Integer id) {
		return findById(id);
	}

	@Override
	public List<User> searchUserByEmailID(String emailId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("emailId", emailId);
		return searchByQuery(QUERY_BY_EMAIL, paramMap);
	}

	@Override
	public User removeUser(Integer id) {
		return removeEntity(id);
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	public User addProduct(Integer userId, Product product) {
		User retrieveUser = retrieveUser(userId);
		retrieveUser.getProducts().add(product);
		getEntityManager().merge(retrieveUser);
		getEntityManager().flush();
		return retrieveUser;
	}

}
