-- db생성
create database krustykrabdb;
use krustykrabdb;

-- admin계정 생성
insert into user Values(0,'ADMIN','admin','admin','admin','admin','admin','admin','admin');

-- menu 데이터 삭제
set sql_safe_updates=0;
delete from menu;
set sql_safe_updates=1;