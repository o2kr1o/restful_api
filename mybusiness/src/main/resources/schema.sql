DROP TABLE IF EXISTS client;
CREATE TABLE client (
	client_id IDENTITY NOT NULL PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	first_name_kana VARCHAR(255),
	last_name_kana VARCHAR(255),
	age VARCHAR(5),
	gender VARCHAR(5),
	workplace VARCHAR(155),
	job_title VARCHAR(100),
	zip_code VARCHAR(10),
	address VARCHAR(255),
	building_name VARCHAR(100),
	contact_number VARCHAR(255),
	e_mail VARCHAR(254),
	payment_method VARCHAR(10)
);

DROP TABLE IF EXISTS visit_info;
CREATE TABLE visit_info (
	visit_id IDENTITY NOT NULL PRIMARY KEY,
	client_id BIGINT NOT NULL,
	entery_time TIMESTAMP,
	exit_time TIMESTAMP
);