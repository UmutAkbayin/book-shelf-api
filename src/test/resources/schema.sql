

CREATE TABLE IF NOT EXISTS authors (
                                       id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                       first_name VARCHAR(100) NOT NULL,
                                       last_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS publishers (
                                          id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                          name VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
                                     id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                     title VARCHAR(200) NOT NULL,
                                     publisher_id INT NOT NULL,
                                     publishing_year INT NOT NULL CHECK (publishing_year >= 1450),
                                     status VARCHAR(20) DEFAULT 'NOT_READ' NOT NULL CHECK (status IN ('READ', 'WANT_TO_READ', 'READING', 'NOT_READ')),
                                     FOREIGN KEY (publisher_id) REFERENCES publishers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS book_authors (
                                    book_id INT NOT NULL,
                                    author_id INT NOT NULL,
                                    PRIMARY KEY (book_id, author_id),
                                    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
                                    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);