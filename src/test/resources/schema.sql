CREATE TABLE users (
	user_id BIGINT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(25) NOT NULL,
	dob DATE NOT NULL,
	PRIMARY KEY (user_id)
);

CREATE TABLE movies (
	movie_id BIGINT NOT NULL AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	director VARCHAR(25) NOT NULL,
	release_date DATE,
	rating NUMERIC,
	PRIMARY KEY (movie_id)
	
);