create database totoshop;

create table totoshop_user (
	U_ID varchar(20) not null comment "用戶ID",
	U_NAME varchar(200) not null comment "用戶名",
	U_PASSWORD varchar(200) not null comment "用戶密碼",
	U_PHONE varchar(20) comment "用戶手機",
	U_ADDRESS varchar(50) comment "用戶地址",
	U_SEX varchar(2) not null comment "用戶性別",
	U_CREATE_TIME date not null comment "信息創建時間",
	U_EDIT_TIME date not null comment "信息修改時間",
	primary key(U_ID),
	unique key UK_U_ID(U_ID)
) engine=InnoDB, default charset=utf8, comment "用戶表";

insert into totoshop_user(U_ID, U_NAME)
values ("1", "張學友")