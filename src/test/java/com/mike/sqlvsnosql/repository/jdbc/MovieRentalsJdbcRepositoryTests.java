package com.mike.sqlvsnosql.repository.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.mike.sqlvsnosql.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Testcontainers
@SpringBootTest
public class MovieRentalsJdbcRepositoryTests {

	/*
	 * This is not needed as we specify the URL in
	 * src/test/resources/application.properties
	 */
//	@Container
//	public static MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse("mysql:8.0.25"));

	@Autowired
	MovieRentalsJdbcRepository repository;

	@Test
	public void getById() {
		User user = repository.getUserById(1L);
		assertEquals(new User(1L, "mike", "parker", LocalDate.of(1988, 6, 29)), user);
	}
	
	@Test
	public void getByFirstName() {
		List<User> users = repository.getUsersByFirstName("mike");
		assertEquals(List.of(new User(1L, "mike", "parker", LocalDate.of(1988, 6, 29))), users);
	}
	
	@Test
	public void updateSurname() {
		String newSurname = "NEWSURNAME";
		boolean updated = repository.updateSurname(1, newSurname);
		assertEquals(true, updated);
		assertEquals(newSurname, repository.getUserById(1).getLastName());
	}
	


}
