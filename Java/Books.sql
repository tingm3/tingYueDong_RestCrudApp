DROP DATABASE IF EXISTS books;

CREATE DATABASE books;

SHOW DATABASES;

USE books;

CREATE TABLE author(
	authorId INT,
    firstName VARCHAR(25),
	MiddleName VARCHAR(25),
	LastName VARCHAR(50),
	Gender VARCHAR(1),
	DateOfBirth DATE,
	DateOfDeath DATE,
    CONSTRAINT pk_authorId
		PRIMARY KEY (authorId)
);

CREATE TABLE book(
	bookId INT, 
	title VARCHAR(100),
	PublicationDate date,
    CONSTRAINT pk_bookId
		PRIMARY KEY (bookId)
);

CREATE TABLE format(
	formatId INT,
	formatName VARCHAR(12),
    CONSTRAINT pk_formatId
		PRIMARY KEY (formatId)
);


CREATE TABLE genre(
	genreId  INT,
	genrename VARCHAR(25),
	CONSTRAINT pk_genreId
		PRIMARY KEY (genreId)
);

CREATE TABLE authorBook(
	authorId  INT,
	bookId INT,
	CONSTRAINT pk_authorBook
    		PRIMARY KEY (AuthorId, BookId),
	CONSTRAINT fk_authorBookAuthorId
		FOREIGN KEY (authorId)
        REFERENCES author(authorId),
	CONSTRAINT fk_authorBookBookId
		FOREIGN KEY (bookId)
		REFERENCES book(bookId)
);

CREATE TABLE bookFormat (
	bookId  INT,
	formatId  INT,
	price double,
	quantityOnHand INT,
	
    CONSTRAINT pk_bookFormat
			PRIMARY KEY (bookId, formatId),
	CONSTRAINT fk_bookFormatBookId
		FOREIGN KEY (bookId)
        REFERENCES book(bookId),
	CONSTRAINT fk_bookFormatFormatId
		FOREIGN KEY (formatId)
        REFERENCES format(formatId)
);

CREATE TABLE bookGenre(
	bookId INT,
	genreId INT, 
	CONSTRAINT pk_bookGenre
		PRIMARY KEY (bookId, genreId),
	CONSTRAINT fk_bookGenreBookId
		FOREIGN KEY (bookId)
			REFERENCES book(bookID), 
	CONSTRAINT fk_bookGenreGenreId
		FOREIGN KEY (genreId)
			REFERENCES genre(genreId)
);



