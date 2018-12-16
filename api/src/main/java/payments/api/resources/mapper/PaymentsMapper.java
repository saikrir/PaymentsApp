package payments.api.resources.mapper;

import javax.enterprise.context.ApplicationScoped;

import org.dozer.DozerBeanMapper;

import payments.api.entity.User;
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
}
