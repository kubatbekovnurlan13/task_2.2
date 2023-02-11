package kg.kubatbekov.foxminded.dao;

import kg.kubatbekov.foxminded.daoInterfaces.CourseDAO;
import kg.kubatbekov.foxminded.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImplementation implements CourseDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDAOImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> getAll() {
        String SQL_GETALL = "select * from courses;";
        return jdbcTemplate.query(SQL_GETALL, new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public Course getByName(String name) {
        Course course = new Course();
        String SQL_GET = "select * from courses where course_name=?;";

        return jdbcTemplate.query(SQL_GET, new Object[]{name}, new BeanPropertyRowMapper<>(Course.class))
                .stream().findAny().orElse(course);
    }


    @Override
    public void save(Course course) {
        String SQL_SAVE = "insert into courses (course_name, course_description) VALUES (?,?);";
        jdbcTemplate.update(SQL_SAVE, course.getCourse_name(), course.getCourse_description());
    }

    @Override
    public boolean update(Course course) {
        String SQL_UPDATE = "update courses set course_name=?, course_description=? where course_id=?;";
        return 0 < jdbcTemplate.update(SQL_UPDATE, course.getCourse_name(), course.getCourse_description(), course.getCourse_id());
    }


    @Override
    public boolean deleteById(int course_id) {
        String SQL_DELETE = "delete from courses where course_id=?;";
        return 0 < jdbcTemplate.update(SQL_DELETE, course_id);
    }
}
