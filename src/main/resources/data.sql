INSERT INTO Role VALUES (1, 'ADMIN');
INSERT INTO Role VALUES (2, 'BUYER');
INSERT INTO Role VALUES (3, 'SELLER');


INSERT INTO User (user_id, active, password, username)VALUES (3, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'buyer@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(3,2);
INSERT INTO buyer (coupons, email, first_name, last_name, user_id, id)  VALUES(0,'buyer@gmail.com','Mahlet','Saron',3,1);



INSERT INTO User (user_id, active, password, username)VALUES (2, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'seller@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(2,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID) VALUES(1,'seller@gmail.com','seller','112','111',2);



INSERT INTO Category VALUES (1, 'Phone');
INSERT INTO Category VALUES (2, 'Computer');

INSERT INTO Product VALUES ( 2,3 , 'Phone the lightest 7 inch tablet with a quad-core S4',true, 13,'123','iPhone ','iPhone 7s',1,1);
INSERT INTO Product VALUES ( 3,3 , 'Google Nexus 7 is the lightest 7 inch tablet with a',false, 134.7,'P1235','Dell Inspirit','Dell Inspiron',2,1);


INSERT INTO Product VALUES ( 4,3 , 'Phone the lightest 7 inch tablet with a quad-core S',true, 1986.6,'123','iPhone 6s','iPhone 7s',1,1);
INSERT INTO Product VALUES ( 5,3 , 'Google Nexus 7 is the lightest 7 inch tablet with a',true, 1254.5,'P1235','Dell Inspirit','Dell Inspiron',2,1);

INSERT INTO Product VALUES ( 6,3 , 'Phone the lightest 7 inch tablet with a quad-core S4',true, 1244.5,'123','iPhone 6s','iPhone 7s',1,1);
INSERT INTO Product VALUES ( 7,3 , 'Google Nexus 7 is the lightest 7 inch tablet with',true, 562.5,'P1235','Dell Inspirit','Dell Inspiron',2,1);

