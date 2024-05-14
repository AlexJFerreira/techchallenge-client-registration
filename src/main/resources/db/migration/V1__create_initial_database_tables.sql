CREATE TABLE client (
                        cpf VARCHAR(11) PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        date_of_birth DATE NOT NULL,
                        registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);