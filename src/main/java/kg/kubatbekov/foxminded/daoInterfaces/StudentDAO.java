package kg.kubatbekov.foxminded.daoInterfaces;

import kg.kubatbekov.foxminded.model.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    boolean update(Student student);

    Student getByName(String name);

    List<Student> getAll();

    boolean deleteById(int student_id);

}
