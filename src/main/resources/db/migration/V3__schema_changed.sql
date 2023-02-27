drop table students_courses;

CREATE TABLE students_courses
(
    student_id int not null,
    course_id  int not null,
    primary key (student_id, course_id),
    foreign key (student_id) references students (student_id) ON DELETE CASCADE,
    foreign key (course_id) references courses (course_id) ON DELETE CASCADE
);