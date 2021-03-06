CREATE SEQUENCE product_id_seq;

CREATE TABLE product (
	id BIGINT NOT NULL DEFAULT NEXTVAL('product_id_seq'),
	description VARCHAR(255) NOT NULL,
	manufacturer VARCHAR(255) NOT NULL,
	name VARCHAR(100) NOT NULL,
	weight DECIMAL NOT NULL,
	type VARCHAR(100) NOT NULL,
	short_code VARCHAR(100) NOT NULL UNIQUE,
	price_markup DECIMAL NULL DEFAULT 1.15
);