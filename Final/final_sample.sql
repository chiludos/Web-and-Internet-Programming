drop table if exists q_courses;
drop table if exists s_courses;
drop table if exists course_mappings;

create table q_courses (
	id int primary key auto_increment,
	name varchar(10)

);

create table s_courses (
	id int primary key auto_increment,
	name varchar(10)

);

create table course_mappings (
	q_course_id int,
	s_course_id int

);

insert into q_courses values (1, 'CS122');
insert into q_courses values (2, 'CS201');
insert into q_courses values (3, 'CS202');
insert into q_courses values (4, 'CS203');

insert into s_courses values (1, 'CS2011');
insert into s_courses values (2, 'CS2012');
insert into s_courses values (3, 'CS2013');

insert into course_mappings values (2, 1);
insert into course_mappings values (3, 2);

