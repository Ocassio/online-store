use `online-store`;

insert into CATEGORIES values (1, 'category1');
insert into CATEGORIES values (2, 'category2');
insert into CATEGORIES values (3, 'category3');
insert into CATEGORIES values (4, 'category4');

insert into users values (1, 'email1@yandex.ru', '123', 'Valentin', 'Goncharov', 'Gai 1');
insert into users values (2, 'email2@yandex.ru', '123', 'Alexander', 'Shindin', 'XZ');
insert into users values (3, 'email3@yandex.ru', '123', 'Alexander', 'Ionov', 'XZ');

insert into OFFERS values(1, 'Offer1', 300, 1);
insert into OFFERS values(2, 'Offer2', 300, 1);
insert into OFFERS values(3, 'Offer3', 200, 1);
insert into OFFERS values(4, 'Offer4', 200, 2);
insert into OFFERS values(5, 'Offer5', 200, 2);
insert into OFFERS values(6, 'Offer6', 200, 3);
insert into OFFERS values(7, 'Offer7', 200, 3);
insert into OFFERS values(8, 'Offer8', 200, 4);

Insert into ratings values(1, 1, 1, 5, 'shit');
Insert into ratings values(2, 1, 1, 5, 'shit');
Insert into ratings values(3, 3, 2, 5, 'shit');

Insert into sales_orders values(1, 1, '2015-04-01 10:00:00');
Insert into sales_orders values(2, 2, '2015-04-01 10:00:00');
Insert into sales_orders values(3, 3, '2015-04-01 10:00:00');
Insert into sales_orders values(4, 3, '2015-04-01 10:00:00');

Insert into sales_order_entries values(1, 1, 1, 5);
Insert into sales_order_entries values(2, 2, 4, 5);
Insert into sales_order_entries values(3, 3, 5, 5);