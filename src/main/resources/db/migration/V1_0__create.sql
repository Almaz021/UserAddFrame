DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       BIGSERIAL,
    name     VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    ---------------------------------
    CONSTRAINT name_uq UNIQUE (name)
);