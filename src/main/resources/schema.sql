CREATE TABLE users (
	user_id NUMERIC NOT NULL,
	first_name VARCHAR(25) NOT NULL,
	surname VARCHAR(25) NOT NULL,
	dob DATE NOT NULL
);

CREATE TABLE movies (
	movie_id NUMERIC NOT NULL,
	title VARCHAR(100) NOT NULL,
	director VARCHAR(25) NOT NULL,
	release_date DATE,
	rating NUMERIC
);