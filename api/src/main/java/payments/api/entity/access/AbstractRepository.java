package payments.api.entity.access;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class AbstractRepository<T> {

    @PersistenceContext(name = "MyPayments")
    private EntityManager entityManager;

    protected T findById(Integer primaryKey) {
	return (T) entityManager.find(getEntityClass(), primaryKey);
    }

    protected T saveEntity(T entity) {
	entityManager.persist(entity);
	entityManager.flush();
	return entity;
    }

    protected List<T> searchByQuery(String jpaQueryStr, Map<String, ?> paramValueMap) {
	Query jpaQuery = entityManager.createQuery(jpaQueryStr);
	paramValueMap.entrySet().stream().forEach(entry -> jpaQuery.setParameter(entry.getKey(), entry.getValue()));
	return jpaQuery.<T>getResultList();
    }

    protected T removeEntity(Integer primaryKey) {
	T entity = findById(primaryKey);
	if (!Objects.isNull(entity)) {
	    entityManager.remove(entity);
	}
	return entity;
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }

    protected abstract Class<T> getEntityClass();
}
