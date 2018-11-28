package payments.api.service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import payments.api.entity.User;
import payments.api.entity.access.UserRepository;

@Stateless
@Local
@Transactional
public class UserServiceImpl implements UserService {

	@Inject
	UserRepository userRepository;

	@Override
	public User getUser(String userId) {
		return userRepository.retrieveUser(Integer.parseInt(userId));
	}

	@Override
	public void newUser(User user) {
		userRepository.saveUser(user);
	}
}
