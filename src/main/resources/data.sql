INSERT INTO Role VALUES (1, 'ADMIN');
INSERT INTO Role VALUES (2, 'BUYER');
INSERT INTO Role VALUES (3, 'SELLER');


INSERT INTO User (user_id, active, password, username)
VALUES (3, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'buyer@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(3,2);
INSERT INTO buyer (coupons, email, first_name, last_name, user_id, id)  VALUES(0,'buyer@gmail.com','Mahlet','Saron',3,1);



INSERT INTO User (user_id, active, password, username)VALUES
(2, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'seller@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(2,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(1,'seller@gmail.com','Mahlet Sharew','112','111',2);


INSERT INTO User (user_id, active, password, username)
VALUES (5, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'mahi@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(5,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(3,'mahi@gmail.com','Gebrehiywet ','112','111',5);


INSERT INTO User (user_id, active, password, username)VALUES
(4, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'lina@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(4,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(4,'lina@gmail.com','Saron','112','111',4);



INSERT INTO User (user_id, active, password, username)VALUES
(6, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'lina@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(6,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(6,'girma@gmail.com','Girma','112','111',6);



INSERT INTO User (user_id, active, password, username)
VALUES (7, 1,'$2a$10$OwJ59e2wB42l1JjePYHg6.N8Gg17W8Dmy3xwAm.QKJA47bTYpnu7e', 'admin@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(7, 1);
INSERT INTO Admin (email, first_name, last_name, user_id, id)
VALUES('admin@gmail.com','admin first name','admin last name',7,7);



INSERT INTO Category VALUES (1, 'Phone');
INSERT INTO Category VALUES (2, 'Computer');
INSERT INTO Category VALUES (3, 'Food');

INSERT INTO Product VALUES ( 20,3 , 'Phone the lightest 7 inch tablet with a quad-core S4',true, 13,'P123','iPhone ','iPhone 7s',1,1);
INSERT INTO Product VALUES ( 21,3 , 'Google Nexus 7 is the lightest 7 inch tablet with a',false, 134.7,'pC1235','Dell Inspirit','Dell Inspiron',2,1);


INSERT INTO Product VALUES ( 22,3 , 'Phone the lightest 7 inch tablet with a quad-core S',true, 1986.6,'P1234','Samsung Inspiron','Samsung Inspiron ',1,1);
INSERT INTO Product VALUES ( 23,3 , 'Google Nexus 7 is the lightest 7 inch tablet with a',true, 1254.5,'C123','MAC Inspirit','MAC Inspiron',2,1);

INSERT INTO Product VALUES ( 24,3 , 'Phone the lightest 7 inch tablet with a quad-core S4',true, 1244.5,'P12345','iPhone 6s','Phone SAm',1,1);
INSERT INTO Product VALUES ( 26,3 , 'Google Nexus 7 is the lightest 7 inch tablet with',true, 562.5,'C1234','Dell Inspirit','Dell Inspiron',2,1);

INSERT INTO Product VALUES ( 27,3 , 'Foods against each other by labelling them',true, 562.5,'F1234','Apple ','Apple Inspiron',3,1);
INSERT INTO Product VALUES ( 28,3 , 'Foods against each other by labelling them',true, 562.5,'F123','Banana','Banana Inspiron',3,1);

