package payments.api.entity.access;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import payments.api.entity.User;

public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext(unitName = "MyPayments_TEST")
	private EntityManager entityManager;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public User saveUser(User user) {

		logger.info("Saving " + user.getName());

		entityManager.getTransaction().begin();

		entityManager.persist(user);

		entityManager.getTransaction().commit();

		return user;
	}

	@Override
	public User retrieveUser(Integer id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUserByEmailID(String emailId) {
		return entityManager.createQuery("SELECT u from User u WHERE c.emailId = :emailId")
				.setParameter("emailId", emailId).getResultList();
	}

	@Override
	public User removeUser(Integer id) {
		logger.info("Deleting User " + id);

		User user = retrieveUser(id);

		entityManager.remove(user);

		return user;
	}

}
