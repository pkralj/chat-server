create table users (
    user_name varchar(255) not null,
    name varchar(255),
    surname varchar(255)
);

insert into users (user_name) values ('user1');
insert into users (user_name, name, surname) values ('user2', 'Ivan', 'Horvat');