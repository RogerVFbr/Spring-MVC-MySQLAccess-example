create database javaee_at;

use javaee_at;

create table student (
	studentid int AUTO_INCREMENT PRIMARY KEY,
    birthdate varchar(50) NOT NULL,
    userid_fk int NOT NULL,
    courseid_fk int NOT NULL
);

insert into student(birthdate, userid_fk, courseid_fk) values('27-03-1979', 1, 1);
insert into student(birthdate, userid_fk, courseid_fk) values('13-05-1999', 2, 1);
insert into student(birthdate, userid_fk, courseid_fk) values('05-02-2005', 3, 2);
insert into student(birthdate, userid_fk, courseid_fk) values('07-03-2007', 4, 2);
insert into student(birthdate, userid_fk, courseid_fk) values('22-11-2002', 5, 3);
insert into student(birthdate, userid_fk, courseid_fk) values('15-06-2001', 6, 3);


create table user (
	userid int AUTO_INCREMENT PRIMARY KEY,
    enrollment int NOT NULL,
    name varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    profileid_fk int NOT NULL
);

insert into user(enrollment, name, password, email, profileid_fk) values(121212, 'Finken Bunzen', '1234', 'finken@bunzen.com', 1);
insert into user(enrollment, name, password, email, profileid_fk) values(234234, 'Ronken Kamzen', '1234', 'ronken@kamzen.com', 1);
insert into user(enrollment, name, password, email, profileid_fk) values(343466, 'Duden Lonzen', '1234', 'duden@lonzen.com', 2);
insert into user(enrollment, name, password, email, profileid_fk) values(567567, 'Granden Tosken', '1234', 'granden@tosken.com', 2);
insert into user(enrollment, name, password, email, profileid_fk) values(876876, 'Sauren Bingen', '1234', 'sauren@bingen.com', 1);
insert into user(enrollment, name, password, email, profileid_fk) values(890890, 'Lurien Trostky', '1234', 'lurien@trostky.com', 3);
insert into user(enrollment, name, password, email, profileid_fk) values(890890, 'Hai Chin Chuo', '1234', 'hai@chin.com', 2);
insert into user(enrollment, name, password, email, profileid_fk) values(890890, 'Deng Xiao Ping', '1234', 'deng@xiao.com', 2);
insert into user(enrollment, name, password, email, profileid_fk) values(890890, 'Ko Kun Han', '1234', 'ko@kun.com', 3);


create table profile (
	profileid int AUTO_INCREMENT PRIMARY KEY,
    profilename varchar(100) NOT NULL
);

insert into profile(profilename) values('Regular User');
insert into profile(profilename) values('Power User');
insert into profile(profilename) values('Admin');


create table teacher (
	teacherid int AUTO_INCREMENT PRIMARY KEY,
    title varchar(100) NOT NULL,
    userid_fk int NOT NULL
);

insert into teacher(title, userid_fk) values('Dr.', 7);
insert into teacher(title, userid_fk) values('Pf.', 8);
insert into teacher(title, userid_fk) values('Ex.', 9);


create table course (
	courseid int AUTO_INCREMENT PRIMARY KEY,
    coursename varchar(100) NOT NULL
);

insert into course (coursename) values('Computer Science');
insert into course (coursename) values('Software Engineering');


create table subject (
	subjectid int AUTO_INCREMENT PRIMARY KEY,
    subjectcode varchar(100) NOT NULL,
    subjectname varchar(100) NOT NULL,
    courseid_fk int NOT NULL
);

insert into subject (subjectcode, subjectname, courseid_fk) values('OOP', 'Object Oriented Programming', 1);
insert into subject (subjectcode, subjectname, courseid_fk) values('TDD', 'Test Driven Design', 1);
insert into subject (subjectcode, subjectname, courseid_fk) values('JS', 'Java Spring', 2);
insert into subject (subjectcode, subjectname, courseid_fk) values('DSI', 'Data Science & IOT', 2);


create table class (
	classid int AUTO_INCREMENT PRIMARY KEY,
    classcode varchar(100) NOT NULL,
    classroom varchar(100) NOT NULL,
    subjectid_fk int NOT NULL,
    teacherid_fk int NOT NULL
);

insert into class (classcode, classroom, subjectid_fk, teacherid_fk) values('CC01', 'CR102', 2, 1);
insert into class (classcode, classroom, subjectid_fk, teacherid_fk) values('CC02', 'CR214', 1, 3);


create table grade (
    gradeid int AUTO_INCREMENT PRIMARY KEY,
    av1 float,
    av2 float,
    studentid_fk int NOT NULL,
    classid_fk int NOT NULL
);

insert into grade (av1, av2, studentid_fk, classid_fk) values(7.5, 8.2, 1, 1);
insert into grade (av1, av2, studentid_fk, classid_fk) values(7.5, 8.2, 2, 1);
insert into grade (av1, av2, studentid_fk, classid_fk) values(7.5, 8.2, 3, 1);
insert into grade (av1, av2, studentid_fk, classid_fk) values(7.5, 8.2, 4, 2);
insert into grade (av1, av2, studentid_fk, classid_fk) values(7.5, 8.2, 5, 2);
insert into grade (av1, av2, studentid_fk, classid_fk) values(7.5, 8.2, 6, 2);








