package com.mike.sqlvsnosql.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mike.sqlvsnosql.model.User;

@Repository
public class MovieRentalsJdbcRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> userMapper = null;
//			(rs, rowNum) -> new User(rs.getLong("user_id"), 
//						             rs.getString("first_name"), 
//						             rs.getString("last_name"), 
//						             rs.getDate("dob").toLocalDate());
	
	public List<User> getUsersByFirstName(String firstName) {
		List<User> users = jdbcTemplate.query("SELECT user_id, first_name, last_name, dob "
				                            + "FROM users "
				                            + "WHERE first_name = ?",
				new Object[] { firstName }, 
				new int[] {java.sql.Types.VARCHAR},
				userMapper);
		return users;
	}
	
	public User getUserById(long id) {
		User user = jdbcTemplate.queryForObject("SELECT user_id, first_name, last_name, dob "
				                            + "FROM users "
				                            + "WHERE user_id = ?",
                new Object[] { id },
				new int[] {java.sql.Types.NUMERIC},
				userMapper);
		return user;
	}
	
	public boolean updateSurname(long userId, String last_name) {
		int numUpdated = jdbcTemplate.update("UPDATE users "
				            + "SET last_name = ? "
							+ "WHERE user_id = ?",
                new Object[] { last_name, userId });
		return numUpdated == 1;
	}
	
	

}
