

create database my_bank;
use my_bank;

create table my_bank.ACCOUNTS(
	num varchar(12) primary key,
	holderName varchar(200),
	balance double,
	type varchar(20)
);

drop table TXNS;
create table my_bank.TXNS(
	id int primary key auto_increment,
	txn_date datetime,
	amount double,
	type varchar(20),
	closing_balance double,
	description varchar(255),
	acc_num varchar(12) references my_bank.ACCOUNTS(num)
);




insert into my_bank.ACCOUNTS values('1','Nag',1000.00,'SAVING');
insert into my_bank.ACCOUNTS values('2','Ria',1000.00,'SAVING');
