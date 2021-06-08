package com.mike.sqlvsnosql.mysql;

import javax.activation.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.mike.sqlvsnosql.model.User;

@Testcontainers
@SpringBootTest
public class MySqlTests {
	
	/*
	 * This is not needed as we specify the URL in src/test/resources/application.properties
	 */
//	@Container
//	public static MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse("mysql:8.0"));
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Test
	public void something() {
//		jdbcTemplate.query(
//		        "SELECT user_id, first_name, surname FROM users WHERE first_name = ?", new Object[] { "Mike" },
//		        (rs, rowNum) -> new User(rs.getLong("user_id"), rs.getString("first_name"), rs.getString("surname"), null)
//		    ).forEach(user -> System.out.println(user.toString()));
		
		jdbcTemplate.query(
		        "SELECT VERSION()",
		        (rs, rowNum) -> rs.getString("VERSION()")
		    ).forEach(version -> System.out.println(version));
	}

}
