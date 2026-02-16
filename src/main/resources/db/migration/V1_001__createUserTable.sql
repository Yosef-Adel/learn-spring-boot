CREATE TABLE HC_USER (
                         ID          BIGINT AUTO_INCREMENT PRIMARY KEY,
                         EMAIL       VARCHAR(255) NOT NULL UNIQUE,
                         FIRST_NAME  VARCHAR(255),
                         LAST_NAME   VARCHAR(255)
);

-- Seed a test user
INSERT INTO HC_USER (EMAIL, FIRST_NAME, LAST_NAME) VALUES ('yosef@test.com', 'Yosef', 'Saaid');
INSERT INTO HC_USER (EMAIL, FIRST_NAME, LAST_NAME) VALUES ('john@test.com', 'John', 'Doe');
