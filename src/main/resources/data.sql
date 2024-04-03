insert into user_details(id, birthdate, name)
values (1001, '1992-08-11', 'Adam');
insert into user_details(id, birthdate, name)
values (1002, '1997-08-11', 'Eve');
insert into user_details(id, birthdate, name)
values (1003, '2002-08-11', 'Adam');
insert into user_details(id, birthdate, name)
values (1004, '1997-03-20', 'Kaustubh');

insert into post(id, description, user_id)
values (2001, 'This is a post about topic 1', 1004);
insert into post(id, description, user_id)
values (2002, 'This is a post about topic 2', 1004);
insert into post(id, description, user_id)
values (2003, 'This is a post about topic 3', 1001);
insert into post(id, description, user_id)
values (2004, 'This is a post about topic 4', 1002);