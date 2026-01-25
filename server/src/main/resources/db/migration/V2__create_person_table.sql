CREATE TABLE person (
    id SERIAL,
    username varchar(20) NOT NULL UNIQUE,
    password varchar(60) NOT NULL,
    person_role_id INT NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50),
    PRIMARY KEY (id),
    FOREIGN KEY (person_role_id) REFERENCES person_role(person_role_id)
);
