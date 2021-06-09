package com.mike.sqlvsnosql.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mike.sqlvsnosql.model.User;

@Repository
@Transactional
public class MovieRentalsJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<User> getUsersByFirstName(String firstName) {
		return entityManager.createQuery("SELECT u FROM User u WHERE u.firstName = ?1", User.class)
				            .setParameter(1, firstName)
				            .getResultList();
	}
	
	public User getUserById(long id) {
		return entityManager.find(User.class, id);
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			entityManager.persist(user);
			return user;
		} else {
			return entityManager.merge(user);
		}
		
	}

	public void deleteById(Long id) {
//		entityManager.createQuery("").executeUpdate();
		User user = getUserById(id);
		entityManager.remove(user);
	}
	
	

}
