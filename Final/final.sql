drop table if exists books;

create table books (

	id  int primary key auto_increment, 
	name varchar(40),
	genre varchar(20),
	votes int
);

insert into books values (1, 'Game of Thrones', 'Fantasy', 10);
insert into books values (2, 'Flash Boys', 'Nonfiction', 8);
insert into books values (3, 'Mistborn: The Final Empire', 'Fantasy', 5);