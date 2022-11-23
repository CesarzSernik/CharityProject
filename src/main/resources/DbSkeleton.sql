CREATE DATABASE charity CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE charity;

INSERT INTO role (id, name) VALUES (NULL, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (NULL, 'ROLE_ADMIN');