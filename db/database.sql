-- +----------------------------------------------+
-- | GUI SHADOW database schema                   |
-- +----------------------------------------------+
-- | Version  : 1.0                               |
-- | Language : Standard SQL                      |
-- | Date     : Mon Nov 24 2014                   |
-- | Schema   : shadow/1.0                        |
-- | Authors  : David Soler <aensoler@gmail.com>  |
-- +----------------------------------------------+


-- Database Section
-- ________________ 

--create database shadow;
-- ## REPLACE "main" to "shadow" for no SQLite database.

-- Tables Section
-- _____________

DROP TABLE IF EXISTS main.fields_users;
DROP TABLE IF EXISTS main.types;
DROP TABLE IF EXISTS main.fields;
DROP TABLE IF EXISTS main.users_positions;
DROP TABLE IF EXISTS main.users;
DROP TABLE IF EXISTS main.studies;
DROP TABLE IF EXISTS main.positions;


CREATE TABLE main.studies (
	id	VARCHAR(10)	CONSTRAINT studies_pk PRIMARY KEY,
	name	VARCHAR(100)
);

CREATE TABLE main.positions (
	id	VARCHAR(100)	CONSTRAINT positions_pk PRIMARY KEY
);

CREATE TABLE main.users (
	login		VARCHAR(100)	CONSTRAINT users_pk PRIMARY KEY,
	password	VARCHAR(100)	CONSTRAINT users_password_nn NOT NULL,
	dni		INT(8),
	name		VARCHAR(100)	CONSTRAINT users_name_nn NOT NULL,
	surname		VARCHAR(100)	CONSTRAINT users_surname_nn NOT NULL,
	nia		INT(5)		CONSTRAINT users_nia_nn NOT NULL,
	phone		INT(9),
	address		VARCHAR(100),
	email		VARCHAR(100)	CONSTRAINT users_email_nn NOT NULL,
	study		VARCHAR(100)
		CONSTRAINT users_study_studies_fk REFERENCES studies(id)
		CONSTRAINT users_study_nn NOT NULL
);

CREATE TABLE main.users_positions (
	user_id		VARCHAR(100) CONSTRAINT users_positions_user_id_fk REFERENCES users(login),
	position_id	VARCHAR(100) CONSTRAINT users_positions_position_id_fk REFERENCES positions(id)
);

CREATE TABLE main.types (
	id VARCHAR(100) CONSTRAINT types_pk PRIMARY KEY
);

CREATE TABLE main.fields (
	id	INT		CONSTRAINT fields_id PRIMARY KEY,
	type_id	VARCHAR(100)	CONSTRAINT fields_type_id_fk REFERENCES types(id),
	value	VARCHAR(100)	CONSTRAINT fields_value
);

CREATE TABLE main.fields_users (
	field_id	VARCHAR(100) CONSTRAINT fields_users_field_id_fk REFERENCES fields(id),
	user_id		VARCHAR(100) CONSTRAINT fields_users_user_id_fk	REFERENCES users(login)
);


-- Inserts Section
-- _____________

INSERT INTO main.studies VALUES
	("GII-IS", "Grado en Ingeniería Informática - Mención de Ingeniería de Software"),
	("GII-TI", "Grado en Ingeniería Informática - Mención en Tecnologías de la Información"),
	("GII-C", "Grado en Ingeniería Informática - Mención en Computación");

INSERT INTO main.users VALUES
	("admin", "123", 12123123, "Juan","García", 12345, 983123456, "C/Sin nombre", "admin@gmail.com", "GII-IS");
