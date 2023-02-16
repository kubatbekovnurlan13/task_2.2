package kg.kubatbekov.foxminded.service;

import kg.kubatbekov.foxminded.dao.CourseDAOImplementation;
import kg.kubatbekov.foxminded.dao.GroupDAOImplementation;
import kg.kubatbekov.foxminded.dao.StudentDAOImplementation;
import kg.kubatbekov.foxminded.model.Course;
import kg.kubatbekov.foxminded.model.Group;
import kg.kubatbekov.foxminded.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;

@Component
public class ValueInput implements CommandLineRunner {
    private final Scanner in = new Scanner(System.in);
    private final GroupDAOImplementation groupDAOImplementation;
    private final CourseDAOImplementation courseDAOImplementation;
    private final StudentDAOImplementation studentDAOImplementation;

    @Autowired
    public ValueInput(GroupDAOImplementation groupDAOImplementation, CourseDAOImplementation courseDAOImplementation, StudentDAOImplementation studentDAOImplementation) {
        this.groupDAOImplementation = groupDAOImplementation;
        this.courseDAOImplementation = courseDAOImplementation;
        this.studentDAOImplementation = studentDAOImplementation;
    }

    @Override
    public void run(String... args) {
        doStuff();
    }

    private void doStuff() {
        while (true) {
            int command = getCommand();
            int modelName = getModelName();
            String value = getValue();
            if (Objects.equals(value, "stop")) {
                in.close();
                System.exit(0);
            }
            if (modelName == 1) {
                studentService(command, value);
            } else if (modelName == 2) {
                groupService(command, value);
            } else {
                courseService(command, value);
            }
        }
    }

    private void studentService(int command, String value) {
        if (command == 1) {
            Student student = new Student(value, "Default Last Name", 1);
            studentDAOImplementation.save(student);
        } else if (command == 2) {
            boolean check = studentDAOImplementation.deleteById(Integer.parseInt(value));
            System.out.println("Success: " + check);
        } else if (command == 3) {
            Student student = studentDAOImplementation.getByName(value);
            System.out.println("Result: " + student);
        }
    }

    private void groupService(int command, String value) {
        if (command == 1) {
            Group group = new Group(value);
            groupDAOImplementation.save(group);
        } else if (command == 2) {
            boolean check = groupDAOImplementation.deleteById(Integer.parseInt(value));
            System.out.println("Success: " + check);
        } else if (command == 3) {
            Group group = groupDAOImplementation.getByName(value);
            System.out.println("Result: " + group);
        }
    }

    private void courseService(int command, String value) {
        if (command == 1) {
            Course course = new Course(value, "Default Desc");
            courseDAOImplementation.save(course);
        } else if (command == 2) {
            boolean check = courseDAOImplementation.deleteById(Integer.parseInt(value));
            System.out.println("Success: " + check);
        } else if (command == 3) {
            Course course = courseDAOImplementation.getByName(value);
            System.out.println("Result: " + course);
        }
    }

    private int getCommand() {
        String info = """
                                
                What would you like to do?
                0 - exit
                1 - save
                2 - delete by id
                3 - get by name
                Enter number of command:""";
        System.out.print(info);
        int command = in.nextInt();
        if (command == 0) {
            System.exit(0);
            in.close();
        } else if (command > 3 || command < 1) {
            System.out.println("Wrong command!");
            getCommand();
        }
        return command;
    }

    private int getModelName() {
        String info = """
                                
                To whom do you want to perform this operation?
                0 - exit
                1 - Student
                2 - Group
                3 - Course
                Enter number of command:""";
        System.out.print(info);

        int command = in.nextInt();
        if (command == 0) {
            System.exit(0);
            in.close();
        } else if (command > 3 || command < 1) {
            System.out.println("Wrong command!");
            getModelName();
        }

        return command;
    }

    private String getValue() {
        in.nextLine();

        String info = """
                                
                Enter 'stop' to exit.
                Enter value:""";
        System.out.print(info);
        return in.nextLine();
    }
}
