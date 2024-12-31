CREATE SCHEMA IF NOT EXISTS book_shelf;

USE book_shelf;

CREATE TABLE IF NOT EXISTS `book_shelf`.`authors` (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `book_shelf`.`publishers` (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `book_shelf`.`books` (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL UNIQUE,
    publisher_id INT NOT NULL,
    publishing_year YEAR NOT NULL CHECK (publishing_year >= 1450),
    status ENUM('READ', 'WANT_TO_READ', 'READING', 'NOT_READ') NOT NULL DEFAULT 'NOT_READ',
    PRIMARY KEY (id),
    FOREIGN KEY (publisher_id) REFERENCES book_shelf.publishers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `book_shelf`.`book_authors` (
    book_id INT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES book_shelf.books(id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES book_shelf.authors(id) ON DELETE CASCADE
);