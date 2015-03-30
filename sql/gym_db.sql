DROP DATABASE GYM_V1;
CREATE DATABASE GYM_V1;

USE GYM_V1;


CREATE TABLE CUSTOMERS
(
 id_cust INT NOT NULL AUTO_INCREMENT ,
 name_c varchar(80) NOT NULL,
 celphone varchar(10),
 date_born date,
 sex	char,
 -- height int,
 email varchar(90),
 id_memb INT NOT NULL,
 FOREIGN KEY (id_memb) REFERENCES memberships(id_memb),
 PRIMARY KEY (id_cust)
);

CREATE TABLE PRODUCTS
(
 id_prod INT NOT NULL AUTO_INCREMENT ,
 name_p varchar(80) NOT NULL,
 type_prod varchar(200),
 trade_mark varchar(200),
 pres varchar(200),
 /** flavor varchar(100), */
 descrip text,
 price int,
 quantity int,
 PRIMARY KEY (id_prod)
);

CREATE TABLE SHOPPING_CART
(
 id_shopc INT NOT NULL AUTO_INCREMENT,
 id_prod INT NOT NULL,
 PRIMARY KEY (id_shopc),
 FOREIGN KEY (id_prod) REFERENCES PRODUCTS(id_prod)
);

CREATE TABLE USER_SYS
(
 id_sys INT NOT NULL AUTO_INCREMENT,
 name_sys varchar(80) NOT NULL,
 celphone varchar(10),
 nick varchar(80) NOT NULL,
 type_sys varchar(200),
 pwd varchar(10),
 date_up date,
 PRIMARY KEY (id_sys)
);

CREATE TABLE MEMBERSHIPS
(
 id_memb INT NOT NULL AUTO_INCREMENT ,
 /*id_cust int,*/
 type_memb varchar(40) NOT NULL,
 price_memb int,
 id_sys INT NOT NULL,
 PRIMARY KEY (id_memb),
 /*FOREIGN KEY (id_cust) REFERENCES CUSTOMERS(id_cust),*/
 FOREIGN KEY (id_sys) REFERENCES USER_SYS(id_sys)
);

CREATE TABLE MONTHS
(
 id_mont INT NOT NULL AUTO_INCREMENT ,
 date_pay datetime,
 amounth int,
 id_memb INT NOT NULL,
 id_sys INT NOT NULL,
 PRIMARY KEY (id_mont),
 FOREIGN KEY (id_sys) REFERENCES USER_SYS(id_sys),
 FOREIGN KEY (id_memb) REFERENCES MEMBERSHIPS(id_memb)
);
/*
CREATE TABLE CHARGES
(
 id_charg INT NOT NULL AUTO_INCREMENT ,
 date_pay datetime,
 discount int,
 total int,
 id_mont INT NOT NULL,
 id_memb INT NOT NULL,
 id_sys INT NOT NULL,
 PRIMARY KEY (id_charg),
 FOREIGN KEY (id_mont) REFERENCES MONTHS(id_mont),
 FOREIGN KEY (id_memb) REFERENCES MEMBERSHIPS(id_memb),
 FOREIGN KEY (id_sys) REFERENCES USER_SYS(id_sys)
);
*/


CREATE TABLE SALES
(
 id_sales INT NOT NULL AUTO_INCREMENT,
 date_pay datetime,
 total int,
 id_shopc INT NOT NULL,
 id_sys INT NOT NULL,
 id_cust INT NOT NULL,
 PRIMARY KEY (id_sales),
 FOREIGN KEY (id_shopc) REFERENCES SHOPPING_CART(id_shopc),
 FOREIGN KEY (id_sys) REFERENCES USER_SYS(id_sys),
 FOREIGN KEY (id_cust) REFERENCES CUSTOMERS(id_cust)
);


CREATE TABLE PRESENCES
(
 id_press INT NOT NULL AUTO_INCREMENT ,
 date_press date,
 checkin TIME,
 checkout TIME,
 id_cust INT NOT NULL,
 PRIMARY KEY (id_press),
 FOREIGN KEY (id_cust) REFERENCES CUSTOMERS(id_cust)
);





select * from user_sys where nick = 'JUANITO' and pwd = '123456';

 select  type_sys from user_sys where nick = 'JUANITO' and pwd = '123456';
 
 
 select * from presences;
 
 
 desc customers
 
 
 
 
 
 name_sys varchar(80) NOT NULL,
 nick varchar(80) NOT NULL,
 type_sys varchar(200),
 pwd varchar(10),
 date_up date,

