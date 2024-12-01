CREATE SCHEMA IF NOT EXISTS book_shelf;

CREATE TABLE IF NOT EXISTS `book_shelf`.`authors` (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `book_shelf`.`publishers` (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `book_shelf`.`books` (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    author_id INT NOT NULL,
    publisher_id INT NOT NULL,
    publishing_year YEAR NOT NULL CHECK (publishing_year >= 1450),
    status ENUM('read', 'want to read', 'reading', 'not read') NOT NULL DEFAULT 'not read',
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES book_shelf.authors(id) ON DELETE CASCADE,
    FOREIGN KEY (publisher_id) REFERENCES book_shelf.publishers(id) ON DELETE CASCADE
);