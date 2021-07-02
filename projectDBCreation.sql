Drop database if exists projectdb;
create database projectdb;

use projectdb;

drop table if exists restaurant;
create table restaurant(
	id int auto_increment primary key,
    name varchar(30) not null unique,
    address varchar(100) not null,
    password varchar(30) not null
);

drop table if exists client;
create table client(
	id int auto_increment primary key,
    username varchar(30) not null unique,
    address varchar(100) not null,
    password varchar(30) not null
);

drop table if exists driver;
create table driver(
	id int auto_increment primary key,
    username varchar(30) not null unique,
    password varchar(30) not null 
);

drop table if exists orders;
create table orders(
	id int auto_increment primary key,
    is_delivered boolean default false,
    order_date datetime default current_timestamp,
    total_price float not null,
    client_id int, 
    driver_id int, 
    restaurant_id int,
    constraint clientOrder_fk 
		foreign key (client_id) references client(id),
	constraint driverOrder_fk 
		foreign key (driver_id) references driver(id),
	constraint restaurantOrder_fk
		foreign key (restaurant_id) references restaurant(id),
	check (total_price >= 0)
);

drop table if exists menu_items;
create table menu_items(
	id int auto_increment primary key,
    restaurant_id int,
    price float not null,
    name varchar(30) not null,
    description varchar(150),
    constraint restaurantMenu_fk
		foreign key (restaurant_id) references restaurant(id)
);

drop table if exists order_items;
create table order_items(
	order_id int,
    menu_item_id int,
    quantity int,
    constraint order_items_pk
		primary key (order_id, menu_item_id),
	constraint order_fk 
		foreign key (order_id) references orders(id),
	constraint menu_item_fk 
		foreign key (menu_item_id) references menu_items(id)
);

drop table if exists client_rating;
create table client_rating(
	id int auto_increment primary key,
	rating int not null,
    client_id int,
    description varchar(200),
    constraint client_fk 
		foreign key (client_id) references client(id)
);

drop table if exists driver_rating;
create table driver_rating(
	id int auto_increment primary key,
	rating int not null,
    driver_id int,
    description varchar(200),
    constraint driver_fk 
		foreign key (driver_id) references driver(id)
);

drop table if exists restaurant_rating;
create table restaurant_rating(
	id int auto_increment primary key,
	rating int not null,
    restaurant_id int,
    description varchar(200),
    constraint restaurant_fk 
		foreign key (restaurant_id) references restaurant(id)
);




