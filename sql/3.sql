create table messages (
    id int not null ,
    message varchar(255),
    user_name varchar(255),
    group_name varchar(255)
);

insert into messages (id, message, user_name, group_name) values (0,'test', 'user1', 'group1');