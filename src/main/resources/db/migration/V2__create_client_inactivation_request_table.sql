CREATE TABLE client_data_inactivation_request
(
    request_number   INT AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100)                        NOT NULL,
    cep              VARCHAR(8)                          NOT NULL,
    address_number   VARCHAR(10)                         NOT NULL,
    telephone_number VARCHAR(15)                         NOT NULL,
    cpf              VARCHAR(11)                         NOT NULL,
    request_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);
