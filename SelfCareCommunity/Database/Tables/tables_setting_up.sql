-- Persons -- 

CREATE TABLE IF NOT EXISTS PERSONS (
	ID int primary key AUTO_INCREMENT, 
	Name varchar(255),
	Surname varchar(255),
	Picture varchar(),
	Picture_Small varchar(),
	Date_of_birth DATE,
	Gender boolean default 1,
	Zip_Code INT,
	Disease TEXT,
	Interest TEXT
);


-- Person_credentials --

CREATE TABLE IF NOT EXISTS PERSON_CREDENTIALS (
	Login varchar(50) primary key NOT NULL,
	Password varchar(30) NOT NULL,
	Email varchar(50) NOT NULL,
	Person_ID INT NOT NULL,
FOREIGN KEY ( Person_ID ) REFERENCES PERSONS( ID )
);


-- Categories --

CREATE TABLE IF NOT EXISTS CATEGORIES(
	ID int primary key AUTO_INCREMENT,
	Display_Name varchar(100) NOT NULL
);


-- Threads --

CREATE TABLE IF NOT EXISTS THREADS(
	ID int primary key AUTO_INCREMENT,
	Display_Name varchar (250) NOT NULL,
	Author_ID int not null,
	Category_ID int not null,
FOREIGN KEY ( Category_ID ) REFERENCES CATEGORIES ( ID ),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS( ID )
);


-- Posts --

CREATE TABLE  IF NOT EXISTS POSTS(
	ID int primary key AUTO_INCREMENT,
	Author_ID int NOT NULL,
	Thread_ID int not NULL,
	Content TEXT,
	Likes int,
	Posted_Date DATETIME,
FOREIGN KEY ( Thread_ID ) REFERENCES THREADS ( ID ),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS( ID )
);


-- Tags --

CREATE TABLE  IF NOT EXISTS TAGS(
	ID int primary key AUTO_INCREMENT,
	Tag_Name varchar (100) NOT NULL
);


-- Problems --

CREATE TABLE  IF NOT EXISTS PROBLEMS(
	ID int primary key AUTO_INCREMENT,
	Author_ID int NOT NULL,
	Tag_ID int NOT NULL,
	When varchar(255) NOT NULL,
	Where varchar(255) NOT NULL,
	How TEXT NOT NULL,
	Who varchar(255) NOT NULL,
	Why TEXT NOT NULL,
	Consequences TEXT NOT NULL,
	Posted_Date DATETIME,
FOREIGN KEY ( Tag_ID ) REFERENCES TAGS ( ID ),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS( ID )
);


-- Solutions --

CREATE TABLE  IF NOT EXISTS SOLUTIONS(
	ID int primary key AUTO_INCREMENT,
	Author_ID int NOT NULL,
	Tag_ID int NOT NULL,
	Problem_ID int NOT NULL,
	When varchar(255) NOT NULL,
	Where varchar(255) NOT NULL,
	How TEXT NOT NULL,
	Who varchar(255) NOT NULL,
	Why TEXT NOT NULL,
	Consequences TEXT NOT NULL,
	Posted_Date DATETIME,
FOREIGN KEY ( Problem_ID ) REFERENCES PROBLEMS ( ID ),
FOREIGN KEY ( Tag_ID ) REFERENCES TAGS ( ID ),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS( ID )
);

