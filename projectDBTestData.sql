use projectdb;

insert into client (username, address, password) values 
("Test Customer", "123 Street", "123password"),
("John Doe", "760 Drive", "password123"),
("Jane Doe", "4827 Route 763", "welcome1");

insert into restaurant (name, address, password) values 
("Timmy's Tacos", "333 Main Street", "tacos"),
("The Pizzeria", "450 King Street", "pizza");

insert into driver (username, password) values
("Driver1", "test1"),
("Driver2", "test2");

insert into menu_items (restaurant_id, price, name, description) values
(1, 9.99, "Taco Combo", "2 Tacos with chips and a drink"),
(1, 2.00, "Sprite", null),
(1, 4.50, "Breakfast Burrito", null),
(2, 12.99, "Medium Pizza", "12 inch 2-topping pizza"),
(2, 2.99, "2L Coke", null),
(2, 17.99, "Party Pizza", "21 X 15 inches, 3 toppings");

insert into orders (total_price, client_id, restaurant_id) values 
(6.50, 2, 1),
(17.99, 1, 2),
(20.98, 3, 2);

insert into order_items (order_id, menu_item_id, quantity) values 
(1, 3, 1),
(1, 2, 1),
(2, 6, 1),
(3, 6, 1),
(3, 5, 1);

insert into client_rating (rating, client_id, description) values 
(5, 3, "very polite"),
(3, 2, "doesn't tip");

insert into restaurant_rating (rating, restaurant_id, description) values 
(4, 1, "yummy"),
(5, 2, "Best pizza in town!");

insert into driver_rating (rating, driver_id, description) values 
(5, 1, "Always on time"),
(2, 2, "Arrived very late");



