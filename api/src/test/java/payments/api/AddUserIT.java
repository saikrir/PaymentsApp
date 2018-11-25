package payments.api;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import payments.api.entity.Product;
import payments.api.entity.User;

public class AddUserIT {
	private final String PERSISTENCE_UNIT_NAME = "MyPayments_TEST";
	private EntityManagerFactory factory;

	public void loadPersistanceUnit() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		User user = new User();
		user.setName("Test");
		user.setEmailId("rao.saikrishna@gmail.com");

		Product p = new Product();
		p.setName("BOA");
		p.setPaymentDueBy(new Date());
		user.getProducts().add(p);

		em.persist(user);
		em.getTransaction().commit();

		em.close();
	}

	public static void main(String[] args) {
		AddUserIT userIt = new AddUserIT();
		userIt.loadPersistanceUnit();
		System.out.println("Done");
	}
}
