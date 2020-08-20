create database posjava;
use posjava;

create table userposjava(
  
  id bigint not null auto_increment,
  nome character varying(255),
  email character varying(255),
  constraint user_pk primary key(id)

);

insert into userposjava(nome, email) values("Pedro Rangel", "pedro@gmail.com");
select * from userposjava;

create database cursojsp;
use cursojsp;
create table usuario(

  id bigint not null auto_increment,
  login character varying(255),
  senha character varying(255),
  constraint user_pk primary key(id)
);

alter table usuario add column nome character varying(255);
alter table usuario add column telefone int;
alter table usuario drop column telefone;
ALTER TABLE usuario MODIFY COLUMN telefone character varying(255);