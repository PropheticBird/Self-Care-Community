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
 
CREATE TABLE IF NOT EXISTS CATEGORIES(
	ID int primary key AUTO_INCREMENT,
	Display_Name varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS THREADS(
	ID int primary key AUTO_INCREMENT,
	Display_Name varchar (250) NOT NULL,
	Author_ID int not null,
	Category_ID int not null,
FOREIGN KEY (Category_ID) REFERENCES CATEGORIES (ID),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS(ID)
);

CREATE TABLE  IF NOT EXISTS POSTS(
	ID int primary key AUTO_INCREMENT,
	Author_ID int NOT NULL,
	Thread_ID int not NULL,
	Content TEXT,
	Likes int,
	Posted_Date DATE,
FOREIGN KEY (Thread_ID) REFERENCES THREADS (ID),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS(ID)
);