package kg.kubatbekov.foxminded.service;

import kg.kubatbekov.foxminded.dao.CourseDAOImplementation;
import kg.kubatbekov.foxminded.dao.GroupDAOImplementation;
import kg.kubatbekov.foxminded.dao.StudentDAOImplementation;
import kg.kubatbekov.foxminded.model.Course;
import kg.kubatbekov.foxminded.model.Group;
import kg.kubatbekov.foxminded.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Maker {
    private final Group group;
    private final Course course;
    private final Student student;
    private final GroupDAOImplementation groupDAOImplementation;
    private final CourseDAOImplementation courseDAOImplementation;
    private final StudentDAOImplementation studentDAOImplementation;

    @Autowired
    public Maker(Group group, Course course, Student student, GroupDAOImplementation groupDAOImplementation, CourseDAOImplementation courseDAOImplementation, StudentDAOImplementation studentDAOImplementation) {
        this.group = group;
        this.course = course;
        this.student = student;
        this.groupDAOImplementation = groupDAOImplementation;
        this.courseDAOImplementation = courseDAOImplementation;
        this.studentDAOImplementation = studentDAOImplementation;
        doCRUDToGroup();
        doCRUDToCourse();
        doCRUDToStudent();
    }

    public void doCRUDToGroup() {
        System.out.println();

        String name = "group 11";
        group.setGroup_name(name);
        groupDAOImplementation.save(group);
        System.out.println("Save group: " + group);

        Group receivedGroup = groupDAOImplementation.getByName(name);
        System.out.println("Got group by name= " + receivedGroup.getGroup_name() + ", group: " + receivedGroup);

        String newName = "new name - group 11";
        receivedGroup.setGroup_name(newName);
        boolean updated = groupDAOImplementation.update(receivedGroup);
        System.out.println("Updated group: " + receivedGroup + " check: " + updated);

        List<Group> allGroup = groupDAOImplementation.getAll();
        System.out.println("Got all group, size : " + allGroup.size());

        boolean deleted = groupDAOImplementation.deleteById(receivedGroup.getGroup_id());
        System.out.println("Deleted group by id=" + receivedGroup.getGroup_id() + " check: " + deleted);
    }

    public void doCRUDToCourse() {
        System.out.println();

        String name = "course 100";
        String desc = "course desc";
        course.setCourse_name(name);
        course.setCourse_description(desc);
        courseDAOImplementation.save(course);
        System.out.println("Save course: " + course);

        Course receivedCourse = courseDAOImplementation.getByName(name);
        System.out.println("Got course by name= " + receivedCourse.getCourse_name() + ", course: " + receivedCourse);

        String newName = "new name - course 101";
        receivedCourse.setCourse_name(newName);
        boolean updated = courseDAOImplementation.update(receivedCourse);
        System.out.println("Updated course: " + receivedCourse + " check: " + updated);

        List<Course> allCourse = courseDAOImplementation.getAll();
        System.out.println("Got all course, size : " + allCourse.size());

        boolean deleted = courseDAOImplementation.deleteById(receivedCourse.getCourse_id());
        System.out.println("Deleted course by id=" + receivedCourse.getCourse_id() + " check: " + deleted);
    }

    public void doCRUDToStudent() {
        System.out.println();

        String first_name = "student_1000";
        String last_name = "last_name";
        int group_id = 1;
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        student.setGroup_id(group_id);
        studentDAOImplementation.save(student);
        System.out.println("Save student: " + student);

        Student receivedStudent = studentDAOImplementation.getByName(first_name);
        System.out.println("Got student by name= " + receivedStudent.getFirst_name() + ", student: " + receivedStudent);

        String newName = "new name - student 1001";
        receivedStudent.setFirst_name(newName);
        boolean updated = studentDAOImplementation.update(receivedStudent);
        System.out.println("Updated student: " + receivedStudent + " check: " + updated);

        List<Student> allStudent = studentDAOImplementation.getAll();
        System.out.println("Got all student, size : " + allStudent.size());

        boolean deleted = studentDAOImplementation.deleteById(receivedStudent.getStudent_id());
        System.out.println("Deleted student by id=" + receivedStudent.getStudent_id() + " check: " + deleted);
    }


}
