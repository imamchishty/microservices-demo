create sequence product_id_seq;

create table product (
	id BIGINT not null default NEXTVAL('product_id_seq'),
	description varchar(255) not null,
	manufacturer varchar(255) not null,
	name varchar(100) not null,
	price decimal not null
);