CREATE DATABASE catalogue;

USE catalogue;

CREATE TABLE Location (
	id int AUTO_INCREMENT,
	city varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Course (
	code varchar(255) NOT NULL,
	title varchar(255) NOT NULL,
	PRIMARY KEY (code)
);

CREATE TABLE Course_session (
	id int AUTO_INCREMENT,
	start_date DATETIME NOT NULL,
	end_date DATETIME NOT NULL,
	max int,
	course_code varchar(255) NOT NULL,
	location_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (course_code) REFERENCES Course(code),
	FOREIGN KEY (location_id) REFERENCES Location(id)
);

CREATE TABLE Client (
        id int AUTO_INCREMENT,
	lastname varchar(255) NOT NULL,
	firstname varchar(255) NOT NULL,
	address varchar(225) NOT NULL,
	phone varchar(255) NOT NULL,
	email varchar(255),
	course_session_id int NOT NULL,
        PRIMARY KEY (id),
	FOREIGN KEY (course_session_id) REFERENCES Course_session(id)
);

GRANT ALL PRIVILEGES ON catalogue.* TO 'LO54'@'%';

INSERT INTO Location (city)values("Belfort");
INSERT INTO Location (city)values("Montbeliard");
INSERT INTO Location (city)values("Sevenans");

INSERT INTO Course values("MAT","Maths");
INSERT INTO Course values("ENG","Anglais");
INSERT INTO Course values("FRA","Francais");
INSERT INTO Course values("GEO","Geographie");
INSERT INTO Course values("EPS","EPS");

INSERT INTO Course_session (start_date, end_date, max, course_code, location_id)
values('2019-09-04 08:30:00', '2019-09-04 10:30:00', 60, 'MAT', 1);
INSERT INTO Course_session (start_date, end_date, max, course_code, location_id)
values('2019-09-05 09:30:00', '2019-09-05 10:30:00', 20, 'ENG', 1);
INSERT INTO Course_session (start_date, end_date, max, course_code, location_id)
values('2019-09-08 08:00:00', '2019-09-08 09:30:00', 20, 'GEO', 2);
INSERT INTO Course_session (start_date, end_date, max, course_code, location_id)
values('2019-09-04 10:30:00', '2019-09-04 12:00:00', 20, 'ENG', 2);
INSERT INTO Course_session (start_date, end_date, max, course_code, location_id)
values('2019-09-07 15:30:00', '2019-09-07 017:30:00', 20, 'FRA', 3);
INSERT INTO Course_session (start_date, end_date, max, Course_code, location_id)
values('2019-09-07 13:00:00', '2019-09-07 14:30:00', 20, 'EPS', 3);
INSERT INTO Course_session (start_date, end_date, max, Course_code, location_id)
values('2019-09-05 10:30:00', '2019-09-05 11:30:00', 20, 'FRA', 2);
INSERT INTO Course_session (start_date, end_date, max, Course_code, location_id)
values('2019-09-06 17:00:00', '2019-09-06 19:30:00', 20, 'EPS', 1);
INSERT INTO Course_session (start_date, end_date, max, Course_code, location_id)
values('2019-09-06 16:30:00', '2019-09-06 18:00:00', 20, 'GEO', 3);

INSERT INTO Client (lastname, firstname, address, phone, email, course_session_id)
values('DOE', 'John', 'dans la rue', '+33 697683465', 'john.doe@email.com', 1);
INSERT INTO Client (lastname, firstname, address, phone, email, course_session_id)
values('DOE', 'John', 'dans la rue', '+33 697683465', 'john.doe@email.com', 2);
INSERT INTO Client (lastname, firstname, address, phone, email, course_session_id)
values('DOE', 'John', 'dans la rue', '+33 697683465', 'john.doe@email.com', 3);
INSERT INTO Client (lastname, firstname, address, phone, email, course_session_id)
values('DOE', 'John', 'dans la rue', '+33 697683465', 'john.doe@email.com', 4);
INSERT INTO Client (lastname, firstname, address, phone, email, course_session_id)
values('DOE', 'John', 'dans la rue', '+33 697683465', 'john.doe@email.com', 5);
INSERT INTO Client (lastname, firstname, address, phone, email, course_session_id)
values('Ory', 'Thomas', 'Belfort xxx', '+33 9027940734', 'thomas.ory@email.com', 3);
INSERT INTO Client (lastname, firstname, address, phone, email, Course_session_id)
values('Ory', 'Thomas', 'Belfort xxx', '+33 9027940734', 'thomas.ory@email.com', 2);
INSERT INTO Client (lastname, firstname, address, phone, email, Course_session_id)
values('Puget', 'Mathieu', 'Belfort rue du xx', '+33 9027948074', 'mathieu.puget@email.com', 2);
INSERT INTO Client (lastname, firstname, address, phone, email, Course_session_id)
values('Puget', 'Mathieu', 'Belfort rue du xx', '+33 9027940734', 'mathieu.puget@email.com', 4);
