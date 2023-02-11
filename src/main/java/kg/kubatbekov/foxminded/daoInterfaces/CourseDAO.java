package kg.kubatbekov.foxminded.daoInterfaces;

import kg.kubatbekov.foxminded.model.Course;

import java.util.List;

public interface CourseDAO {
    void save(Course course);

    boolean update(Course course);

    Course getByName(String name);

    List<Course> getAll();

    boolean deleteById(int course_id);
}
