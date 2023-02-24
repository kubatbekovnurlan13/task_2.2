package kg.kubatbekov.foxminded.daoTest;

import kg.kubatbekov.foxminded.container.PostgresContainer;
import kg.kubatbekov.foxminded.dao.CourseDAOImplementation;
import kg.kubatbekov.foxminded.model.Course;
import kg.kubatbekov.foxminded.service.ValueInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CourseDAOImplementationTest extends PostgresContainer {
    @MockBean
    ValueInput valueInput;
    @Autowired
    private CourseDAOImplementation courseDAOImplementation;

    @Test
    void save_testSave_whenInputNull() {
        Exception exception = assertThrows(NullPointerException.class,
                () -> courseDAOImplementation.save(null));
        Assertions.assertEquals("Cannot invoke \"kg.kubatbekov.foxminded.model.Course.getCourse_name()\" because \"course\" is null", exception.getMessage());
    }


    @Test
    void update_testUpdateOfValue_whenValueInput() {
        Course course = new Course(1,"course_1_new", "course_description_1_new");
        boolean actual = courseDAOImplementation.update(course);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_testUpdateOfValue_whenValueInputNotUpdated() {
        boolean actual = courseDAOImplementation.update(new Course());
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_testUpdateOfValue_whenNullInput() {
        Exception exception = assertThrows(NullPointerException.class,
                () -> courseDAOImplementation.update(null));
        Assertions.assertEquals("Cannot invoke \"kg.kubatbekov.foxminded.model.Course.getCourse_name()\" because \"course\" is null", exception.getMessage());
    }

    @Test
    void getByName_testGetCourseByName_whenCourseNameInput() {
        Course course = new Course(0,"course_7", "course_description_7");

        Course actual = courseDAOImplementation.getByName(course.getCourse_name());
        Course expected = course;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAll_testGetAllCourses_whenThereIsCourses() {
        int actual = courseDAOImplementation.getAll().size();
        Assertions.assertEquals(10, actual);
    }

    @Test
    void deleteById_testDeleteCourseById_whenThereIsCourse() {
        boolean actual = courseDAOImplementation.deleteById(10);
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteById_testDeleteCourseById_whenCourseNotDeleted() {
        boolean actual = courseDAOImplementation.deleteById(11);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

}
