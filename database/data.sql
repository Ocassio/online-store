use `online-store`;

set SQL_SAFE_UPDATES = 0;

delete from sales_order_entries;
delete from sales_orders;
delete from ratings;
delete from offers;
delete from users;
delete from categories;

insert into categories (name) values
	('category1'),
	('category2'),
    ('category3'),
    ('category4');

insert into users (email, password, name, surname, address) values
	('email1@yandex.ru', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'Valentin', 'Goncharov', 'Gai 1'),
	('email2@yandex.ru', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'Alexander', 'Shindin', 'XZ'),
	('email3@yandex.ru', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'Alexander', 'Ionov', 'XZ');

insert into offers (name, price, category, description) values
	('Offer 1', 12, 1, 'Description 1'),
    ('Offer 2', 121, 1, 'Description 2'),
    ('Offer 3', 122, 2, 'Description 3'),
    ('Offer 4', 123, 3, 'Description 4'),
    ('Offer 5', 124, 3, 'Description 5'),
    ('Offer 6', 125, 4, 'Description 6'),
    ('Offer 7', 126, 4, 'Description 7'),
    ('Offer 8', 127, 2, 'Description 8');

Insert into ratings (user, offer, rating, comment) values
	(1, 1, 5, 'Cool!'),
    (2, 1, 4, 'Just fine.'),
    (3, 1, 3, 'May be better...');

/*Insert into sales_orders values(1, 1, '2015-04-01 10:00:00');
Insert into sales_orders values(2, 2, '2015-04-01 10:00:00');
Insert into sales_orders values(3, 3, '2015-04-01 10:00:00');
Insert into sales_orders values(4, 3, '2015-04-01 10:00:00');

Insert into sales_order_entries values(1, 1, 1, 5);
Insert into sales_order_entries values(2, 2, 4, 5);
Insert into sales_order_entries values(3, 3, 5, 5);*/

set SQL_SAFE_UPDATES = 1;