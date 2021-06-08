package com.mike.sqlvsnosql.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate dob;

}
