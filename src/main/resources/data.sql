insert into users (username, password) VALUES ('egemendrmz', 'ege123');
insert into users (username, password) VALUES ('egebaris', 'ege125');
insert into users (username, password) VALUES ('bicemne', 'bicem135');

insert into stock (symbol, name, price) VALUES ('AAPL', 'apple', 100.00);
insert into stock (symbol, name, price) VALUES ('GOOGL', 'google', 10.00);

insert into user_roles (user_id, roles) VALUES ((select id from users where username='egemendrmz'), 'USER');
insert into user_roles (user_id, roles) VALUES ((select id from users where username='egebaris'), 'USER');
insert into user_roles (user_id, roles) VALUES ((select id from users where username='bicemne'), 'USER');