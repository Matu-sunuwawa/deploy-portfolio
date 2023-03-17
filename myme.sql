create database Myme;
use Myme;
create table contacts(id int,username varchar(100), email varchar(150), subject varchar(100), message varchar(250));
create table contacts(username varchar(100), email varchar(150), subject varchar(100), message varchar(250));
drop table contacts;
select * from contacts;