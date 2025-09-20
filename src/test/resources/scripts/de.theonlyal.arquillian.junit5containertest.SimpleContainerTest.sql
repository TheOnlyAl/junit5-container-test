DROP TABLE IF EXISTS entries;
CREATE TABLE entries(id integer NOT NULL, name varchar(255) NOT NULL UNIQUE, PRIMARY KEY (id));