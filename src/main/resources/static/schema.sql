CREATE TABLE IF NOT EXISTS Calibration_Table
(
    ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    TANK VARCHAR(16) NOT NULL,
    ULLAGE FLOAT   NOT NULL,
    Cub1F  FLOAT NOT NULL,
    Cub    FLOAT NOT NULL,
    Cub1A  FLOAT NOT NULL,
    Cub2A  FLOAT NOT NULL,
    Cub3A  FLOAT NOT NULL,
    Cub4A  FLOAT NOT NULL
);

INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/1P.csv');
INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/1S.csv');
INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/2P.csv');
INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/2S.csv');
INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/3P.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/3S.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/4P.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/4S.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/5P.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/5S.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/6P.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/6S.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/SLP.csv');
--INSERT INTO Calibration_table(ULLAGE, TANK, Cub1F, Cub, Cub1A, Cub2A, Cub3A, Cub4A) SELECT * FROM CSVREAD('src/main/resources/static/SLS.csv');