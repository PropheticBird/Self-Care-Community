CREATE TABLE IF NOT EXISTS PERSON_CREDENTIALS (
	person_credentials_id_PK int NOT NULL AUTO_INCREMENT,
	person_credentials_username varchar(255) NOT NULL DEFAULT "",
	person_credentials_password varchar(255) NOT NULL,
	person_credentials_email varchar(255) NOT NULL,  
	PRIMARY KEY ( person_credentials_id_PK )
);

CREATE TABLE IF NOT EXISTS PERSONS (
	person_id_PK int NOT NULL AUTO_INCREMENT, 
	person_name varchar(255),
	person_surname varchar(255),
	person_profile_picture varchar(255),
	person_birth_date DATE,
	person_gender varchar(255),
	person_zip_code INT, 
	person_health_desease TEXT,
	person_interests TEXT,
	person_id_FK int, 
	PRIMARY KEY ( person_id_PK ),
	FOREIGN KEY ( person_id_FK ) REFERENCES PERSON_CREDENTIALS(person_credentials_id_PK) 
);
