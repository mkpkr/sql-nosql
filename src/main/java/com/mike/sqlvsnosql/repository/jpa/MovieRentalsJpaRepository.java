package com.mike.sqlvsnosql.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mike.sqlvsnosql.model.User;

@Repository
@Transactional
public class MovieRentalsJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	public List<User> getUsersByFirstName(String firstName) {
//		return entityManager.
//	}
	
	public User getUserById(long id) {
		return entityManager.find(User.class, id);
	}
	
	public User upsert(User user) {
		return entityManager.merge(user);
	}
	
	

}
