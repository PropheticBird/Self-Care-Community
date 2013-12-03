CREATE TABLE IF NOT EXISTS PERSONS (
	ID int NOT NULL AUTO_INCREMENT, 
	Name varchar(255),
	Surname varchar(255),
	Picture varchar(),
	Picture_Small varchar(),
	Date_of_birth DATE,
	Gender boolean default 1,
	Zip_Code INT,
	Disease TEXT,
	Interest TEXT, 
	PRIMARY KEY ( ID )
);

CREATE TABLE IF NOT EXISTS PERSON_CREDENTIALS (
	Login varchar(50) NOT NULL,
	Password varchar(30) NOT NULL,
	Email varchar(50) NOT NULL,
	Person_ID INT NOT NULL,
	PRIMARY KEY ( Login ),
	FOREIGN KEY ( Person_ID ) REFERENCES PERSONS(ID)
);
 