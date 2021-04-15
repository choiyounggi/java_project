-- 회원정보 테이블
CREATE TABLE users (
    user_name VARCHAR2(25)
        CONSTRAINT user_name_pk PRIMARY KEY,
    pwd VARCHAR2(100)
        CONSTRAINT user_name_nn NOT NULL,
    membership_point NUMBER(8),
    sign_up_date DATE
);

-- 테이블 삭제
DROP TABLE users PURGE;

-- 테이블 조회
select * from users;

-- 관리자 아이디 생성
INSERT INTO users(user_name, pwd, membership_point, sign_up_date) VALUES('admin', '9ba5fed71c61fbe478cbf4d1a0f6fc266edb5ebdcd104aa57b0c1b85aa2553e0', 1000, sysdate);

SELECT pwd FROM users WHERE user_name = 'admin';

-- 메뉴 테이블
CREATE TABLE menu (
    menu_name VARCHAR2(40)
        CONSTRAINT menu_name_pk PRIMARY KEY,
    tall_price NUMBER (5)
        CONSTRAINT tall_price_nn NOT NULL,
    grande_price NUMBER (5)
        CONSTRAINT grande_price_nn NOT NULL,
    venti_price NUMBER (5)
        CONSTRAINT venti_price_nn NOT NULL
);

-- 메뉴 테이블 삭제
DROP TABLE menu PURGE;

INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('black_tea_lemonade', 6100, 6600, 7100);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('passion_tango_tea_lemonade', 6100, 6600, 7100);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('pink_grapefruit', 6100, 6600, 7100);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('cool_lime', 5900, 6400, 6900);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('lime_passion_tea', 5900, 6400, 6900);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('mint_blend_tea', 5900, 6400, 6900);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('earl_grey_tea', 5300, 5800, 6300);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('chamomile_blend_tea', 5300, 5800, 6300);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('hibiscus_blend_tea', 5300, 5800, 6300);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('passion_fruit_tea', 5300, 5800, 6300);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('coffee', 5800, 6300, 6800);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('brewed_coffee', 3800, 4300, 4800);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('caramel_macchiato', 5800, 6300, 6800);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('caffe_latte', 4600, 5100, 5600);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('caffe_americano', 4100, 4600, 5100);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('caffe_mocha', 4100, 4600, 5100);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('cold_brew', 3800, 4300, 4800);
INSERT INTO menu(menu_name, tall_price, grande_price, venti_price) VALUES('dolce_cold_brew', 3800, 4300, 4800);

SELECT Tall_price FROM menu WHERE menu_name = 'coffee';
SELECT * FROM menu;

-- 장바구니 시퀀스
CREATE SEQUENCE basket_seq START WITH 1 INCREMENT BY 1;

-- 시퀀스 삭제
DROP SEQUENCE basket_seq;

-- 장바구니
CREATE TABLE basket (
    user_name VARCHAR2(40),
    user_order VARCHAR2 (200),
    total_price NUMBER (7)
);

--
UPDATE coffees SET cprice = cprice + 200 WHERE cfid = 2;

DROP TABLE basket PURGE;
SELECT * FROM basket;

-- 주문 관리
CREATE TABLE order_list (
    user_name VARCHAR2(40),
    user_order VARCHAR2 (200),
    payment number (7),
    order_date DATE
);

SELECT * FROM order_list;


