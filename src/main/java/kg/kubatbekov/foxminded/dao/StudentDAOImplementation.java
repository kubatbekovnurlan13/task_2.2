package kg.kubatbekov.foxminded.dao;

import kg.kubatbekov.foxminded.daoInterfaces.StudentDAO;
import kg.kubatbekov.foxminded.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAOImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Student student) {
        String SQL_SAVE = "insert into students (first_name, last_name, group_id) VALUES (?,?,?);";
        jdbcTemplate.update(SQL_SAVE, student.getLast_name(), student.getLast_name(), student.getGroup_id());
    }

    @Override
    public boolean update(Student student) {
        String SQL_UPDATE = "update students set first_name=?, last_name=?, group_id=? where student_id=?;";
        return 0 < jdbcTemplate.update(SQL_UPDATE,
                student.getFirst_name(),
                student.getLast_name(),
                student.getGroup_id(),
                student.getStudent_id());
    }

    @Override
    public Student getById(int student_id) {
        Student student = new Student();
        String SQL_GET = "select * from students where student_id=?;";
        return jdbcTemplate.query(SQL_GET, new Object[]{student_id}, new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(student);
    }

    @Override
    public List<Student> getAll() {
        String SQL_GETALL = "select * from students;";
        return jdbcTemplate.query(SQL_GETALL, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public boolean deleteById(int student_id) {
        String SQL_DELETE = "delete from students where student_id=?;";
        return 0 < jdbcTemplate.update(SQL_DELETE, student_id);
    }
}
