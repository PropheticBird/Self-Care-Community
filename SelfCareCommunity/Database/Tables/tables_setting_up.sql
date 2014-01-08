-- Persons -- 

CREATE TABLE IF NOT EXISTS PERSONS (
	ID int primary key AUTO_INCREMENT, 
	Name varchar(255),
	Surname varchar(255),
	Picture varchar(255),
	Picture_Small varchar(255),
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
	Display_Name varchar (250) not null,
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
	Likes int default 0,
	Dislikes int default 0,
	Posted_Date DATETIME,
FOREIGN KEY ( Thread_ID ) REFERENCES THREADS ( ID ),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS( ID )
);


-- Tags --

CREATE TABLE  IF NOT EXISTS TAGS(
	ID int primary key AUTO_INCREMENT,
	Tag_Name varchar (100) NOT NULL
);


-- Descriptions --

CREATE TABLE IF NOT EXISTS DESCRIPTIONS(
	ID int primary key AUTO_INCREMENT,
	When_ varchar(255) NOT NULL,
	Where_ varchar(255) NOT NULL,
	How TEXT NOT NULL,
	Who varchar(255) NOT NULL,
	Why TEXT NOT NULL,
	Consequences TEXT NOT NULL
);


-- Problems --

CREATE TABLE  IF NOT EXISTS PROBLEMS(
	ID int primary key AUTO_INCREMENT,
	Author_ID int NOT NULL,
	Description_ID int NOT NULL,
	IsProblem boolean NOT NULL default 1,
	Posted_Date DATETIME,
FOREIGN KEY ( Description_ID ) REFERENCES DESCRIPTIONS ( ID ),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS( ID )
);


-- ProblemToTags --

CREATE TABLE IF NOT EXISTS PROBLEM_TO_TAGS(
	Problem_ID int NOT NULL, 
	Tag_ID int NOT NULL,
FOREIGN KEY ( Problem_ID ) REFERENCES PROBLEMS ( ID ),
FOREIGN KEY ( Tag_ID ) REFERENCES TAGS ( ID ),
PRIMARY KEY ( Problem_ID, Tag_ID )
);


-- Solutions --

CREATE TABLE  IF NOT EXISTS SOLUTIONS(
	ID int primary key AUTO_INCREMENT,
	Author_ID int NOT NULL,
	Problem_ID int NOT NULL,
	Description_ID TEXT NOT NULL,
	Posted_Date DATETIME,
FOREIGN KEY ( Problem_ID ) REFERENCES PROBLEMS ( ID ),
FOREIGN KEY ( Author_ID ) REFERENCES PERSONS( ID )
);


-- SolutionToTags --

CREATE TABLE IF NOT EXISTS SOLUTION_TO_TAGS(
	Solution_ID int NOT NULL, 
	Tag_ID int NOT NULL,
FOREIGN KEY ( Solution_ID ) REFERENCES SOLUTIONS ( ID ),
FOREIGN KEY ( Tag_ID ) REFERENCES TAGS ( ID ),
PRIMARY KEY ( Solution_ID, Tag_ID )	
);

-- LikesToUsers --

CREATE TABLE IF NOT EXISTS LIKES_TO_USERS(
 Person_ID int NOT NULL,
 Post_ID int NOT NULL,
FOREIGN KEY ( Person_ID ) REFERENCES PERSONS ( ID ),
FOREIGN KEY ( Post_ID ) REFERENCES POSTS ( ID ),
PRIMARY KEY ( Person_ID, Post_ID )
);

/*
-- DislikesToUsers --

CREATE TABLE IF NOT EXISTS DISLIKES_TO_USERS(
 Person_ID int NOT NULL,
 Post_ID int NOT NULL,
FOREIGN KEY ( Person_ID ) REFERENCES PERSONS ( ID ),
FOREIGN KEY ( Post_ID ) REFERENCES POSTS ( ID ),
PRIMARY KEY ( Person_ID, Post_ID )
);
*/
