DROP DATABASE IF EXISTS movies;
CREATE DATABASE movies;
USE movies;

CREATE TABLE genre(
    genreId INT AUTO_INCREMENT,
    genreName VARCHAR(30) CHARACTER SET utf8mb4 NOT NULL,
    CONSTRAINT pk_genreId
        PRIMARY KEY (genreId)
);

CREATE TABLE director (
    directorId INT AUTO_INCREMENT,
    firstName VARCHAR(30) CHARACTER SET utf8mb4 NOT NULL,
    lastName VARCHAR(30) CHARACTER SET utf8mb4 NOT NULL,
    birthDate DATE,
    CONSTRAINT pk_directorId
        PRIMARY KEY (directorId)
);

CREATE TABLE rating(
    ratingId INT AUTO_INCREMENT,
    ratingName VARCHAR(5) NOT NULL,
    CONSTRAINT pk_ratingId
        PRIMARY KEY (ratingId)
);

CREATE TABLE actor(
    actorId INT AUTO_INCREMENT,
    firstName VARCHAR(30) CHARACTER SET utf8mb4 NOT NULL,
    lastName VARCHAR(30) CHARACTER SET utf8mb4 NOT NULL,
    birthDate DATE,
    CONSTRAINT pk_actorId
        PRIMARY KEY (actorId)
);

CREATE TABLE movie (
    movieId INT AUTO_INCREMENT,
    genreId INT NOT NULL,
    directorId INT,
    ratingId INT,
    title VARCHAR(128) CHARACTER SET utf8mb4 NOT NULL,
    releaseDate DATE,
    CONSTRAINT pk_movieId
        PRIMARY KEY (movieId),
    CONSTRAINT fk_movieGenreId
        FOREIGN KEY (genreId)
        REFERENCES genre(genreId),
    CONSTRAINT fk_movieDirectorId
        FOREIGN KEY (directorId)
        REFERENCES director(directorId),
    CONSTRAINT fk_movieRatingId
        FOREIGN KEY (ratingId)
        REFERENCES rating(ratingId)
);

CREATE TABLE castMembers (
    castMemberId INT AUTO_INCREMENT,
    actorId INT NOT NULL,
    movieId INT NOT NULL,
    role VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL,
    CONSTRAINT pk_castMemberId
        PRIMARY KEY (castMemberId),
    CONSTRAINT fk_castMembersActorId
        FOREIGN KEY (actorId)
        REFERENCES actor(actorId),
    CONSTRAINT fk_castMembersMovieId
        FOREIGN KEY (movieId)
        REFERENCES movie(movieId)
);

SHOW TABLES;
DESCRIBE genre;
DESCRIBE director;
DESCRIBE rating;
DESCRIBE actor;
DESCRIBE movie;
DESCRIBE castMembers;