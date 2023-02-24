drop table students_courses;
drop table students;


CREATE TABLE students
(
    student_id serial primary key,
    group_id   int,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    foreign key (group_id) references groups (group_id) ON DELETE SET NULL
);

CREATE TABLE students_courses
(
    student_id int not null,
    course_id  int not null,
    primary key (student_id, course_id),
    foreign key (student_id) references students (student_id) ON DELETE CASCADE,
    foreign key (course_id) references courses (course_id) ON DELETE CASCADE
);