insert into ROLE(ID, ROLE_NAME) values(1, 'Admin');

insert into USER(ID, Password, user_name, role_id)  values (1, 'password', 'admin', 1);

insert into Buyer(ID, first_Name, last_Name, email, coupons,user_id) values (1, 'first name', 'last name', 'email@gmail.com','2',1);

insert into review(review_id, comment) values (1, 'good');

insert into address(id, city, state, street, zip) values(1, 'Fair field', 'IA', '1000N 4th', 52557);

/*

insert into seller(id, email, full_name, area_code, number, prefix, address_id) values (1, 'email@gmail.com', 'full name', '234','23423423','234',1);

insert into product(id, AVAILABLE_IN_STOR, description, is_available, price, product_number, summary, title, review_review_id, seller_id) values (1, 1, 'this is description', 1, 345.43,4,'this is summary message', 'product title', 1,1);

insert into category(category_id, category_name, products_id) values (1, 'category name', 1);

*/


