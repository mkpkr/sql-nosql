package com.mike.sqlvsnosql.repository.jpa;

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
public class MovieRentalsJpaRepositoryTests {

	/*
	 * This is not needed as we specify the URL in
	 * src/test/resources/application.properties
	 */
//	@Container
//	public static MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse("mysql:8.0.25"));

	@Autowired
	MovieRentalsJpaRepository repository;

	@Test
	public void getById() {
		User user = repository.getUserById(1L);
		assertEquals(new User(1, "mike", "parker", LocalDate.of(1988, 6, 29)), user);
	}
	
//	@Test
//	public void getByFirstName() {
//		List<User> users = repository.getUsersByFirstName("mike");
//		assertEquals(List.of(new User(1, "mike", "parker", LocalDate.of(1988, 6, 29))), users);
//	}
//	
	@Test
	public void updateSurname() {
		User user = repository.getUserById(1L);
		String newLastName = "NEWSURNAME";
		user.setLastName(newLastName);
		User updated = repository.upsert(user);
		assertEquals(user, updated);
		assertEquals(user, repository.getUserById(1L));
	}
	
	@Test
	public void insert() {
		User user = new User();
		user.setFirstName("mickey");
		user.setLastName("mouse");
		user.setDob(LocalDate.of(2000, 1, 1));
		User updated = repository.upsert(user);
		System.out.println(updated.getId());
		assertEquals(user, updated);
		assertEquals(user, repository.getUserById(updated.getId()));
	}
	


}
