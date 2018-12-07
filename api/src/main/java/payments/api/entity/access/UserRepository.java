package payments.api.entity.access;

import java.util.List;

import payments.api.entity.User;

public interface UserRepository {

	String QUERY_BY_EMAIL = "SELECT u from User u WHERE c.emailId = :emailId";

	User saveUser(User user);

	User retrieveUser(Integer id);

	List<User> searchUserByEmailID(String emailId);

	User removeUser(Integer id);
}
