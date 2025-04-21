

CREATE TABLE users (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255),
   password VARCHAR(255),
   created TIMESTAMP,
   modified TIMESTAMP,
   active BOOLEAN,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE token (
  id UUID NOT NULL,
   token VARCHAR(255) NOT NULL,
   user_id VARCHAR(255),
   revoked BOOLEAN NOT NULL,
   expired BOOLEAN NOT NULL,
   created_token TIMESTAMP,
   expires_token TIMESTAMP,
   CONSTRAINT pk_token PRIMARY KEY (id)
);

ALTER TABLE token ADD CONSTRAINT uc_token_token UNIQUE (token);

ALTER TABLE token ADD CONSTRAINT FK_TOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE phones (
  id VARCHAR(255) NOT NULL,
   number VARCHAR(255),
   city_code VARCHAR(255),
   country_code VARCHAR(255),
   user_id VARCHAR(255) NOT NULL,
   CONSTRAINT pk_phones PRIMARY KEY (id)
);

ALTER TABLE phones ADD CONSTRAINT FK_PHONES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

