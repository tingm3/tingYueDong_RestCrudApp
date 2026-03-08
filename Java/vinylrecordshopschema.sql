-- Ting
-- 02/26/2026

DROP DATABASE IF EXISTS vinvylrecordshop;

CREATE DATABASE vinvylrecordshop;

SHOW DATABASES;

USE	vinvylrecordshop;

CREATE TABLE `album` (
  `albumId` INT NOT NULL AUTO_INCREMENT,
  `albumTitle` VARCHAR(100) NOT NULL,
  `label` VARCHAR(50) DEFAULT NULL,
  `releaseDate` DATE DEFAULT NULL,
  `price` DECIMAL(5,2) DEFAULT NULL,
  CONSTRAINT pk_album 
        PRIMARY KEY (albumId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE artist(
	artistId int,
    artistFirstName VARCHAR(25),
    artistLastName VARCHAR(50),
	CONSTRAINT pk_artistId
		PRIMARY KEY(artistId)
); 

DESCRIBE artist;

CREATE TABLE band(
	bandId int,
    bandName VARCHAR(50),
    CONSTRAINT pk_band
		PRIMARY KEY (bandId)
); 

DESC band;


CREATE TABLE song(
	songId int NOT NULL AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
     bandId INT NOT NULL,
    CONSTRAINT pk_song
		PRIMARY KEY (songId),
	CONSTRAINT fk_song_bandId
		FOREIGN KEY (bandId)
		References band(bandId)
); 

CREATE TABLE songAlbum(
	songId INT,
    albumId INT,
    CONSTRAINT pk_songAlbum
		PRIMARY KEY (songId, albumId),
	CONSTRAINT fk_songAlbum_song
		FOREIGN KEY (songId)
        REFERENCES song(songId),
	CONSTRAINT fk_songAlbum_album
		FOREIGN KEY (albumId)
        REFERENCES album(albumId)
);

CREATE TABLE bandArtist(
	bandId INT,
    artistId INT,
    CONSTRAINT pk_bandArtist
		PRIMARY KEY(bandId, artistId),
	CONSTRAINT fk_bandArtist_band
		FOREIGN KEY (bandId)
        REFERENCES band(bandId),
	CONSTRAINT fk_bandArtist_artists
		FOREIGN KEY (artistId)
        REFERENCES artist(artistId)
);

show tables

