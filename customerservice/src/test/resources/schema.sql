CREATE SCHEMA IF NOT EXISTS customerdb;

CREATE TABLE IF NOT EXISTS person (
    id BIGINT NOT NULL AUTO_INCREMENT,
    address VARCHAR(255) NOT NULL,
    age INTEGER,
    gender VARCHAR(255),
    identification VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS client (
    id BIGINT NOT NULL PRIMARY KEY,
    client_id VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    status BIT NOT NULL,
    UNIQUE (client_id),
    CONSTRAINT FK_client_person_id FOREIGN KEY (id) REFERENCES person (id)
);