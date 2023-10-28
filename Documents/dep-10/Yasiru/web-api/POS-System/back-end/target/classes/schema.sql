CREATE TABLE Customer(
                         id INT AUTO_INCREMENT PRIMARY KEY ,
                         name VARCHAR(100) NOT NULL ,
                         address VARCHAR(250) NOT NULL ,
                         contact VARCHAR(20) NOT NULL
);
ALTER TABLE Customer ADD CONSTRAINT uk_contact UNIQUE (contact);