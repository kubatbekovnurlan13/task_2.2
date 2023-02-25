package kg.kubatbekov.foxminded.daoTest;

import kg.kubatbekov.foxminded.container.PostgresContainer;
import kg.kubatbekov.foxminded.dao.StudentDAOImplementation;
import kg.kubatbekov.foxminded.model.Student;
import kg.kubatbekov.foxminded.service.ValueInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StudentDAOImplementationTest extends PostgresContainer {
    @MockBean
    private ValueInput valueInput;
    @Autowired
    private StudentDAOImplementation studentDAOImplementation;

    @Test
    void save_testSave_whenInputNull() {
        Exception exception = assertThrows(NullPointerException.class,
                () -> studentDAOImplementation.save(null));
        assertEquals("Cannot invoke \"kg.kubatbekov.foxminded.model.Student.getFirst_name()\" because \"student\" is null", exception.getMessage());
    }

    @Test
    void update_testUpdateOfValue_whenValueInput() {
        Student student = new Student(1, "first_name_new", "last_name_new", 5);

        boolean actual = studentDAOImplementation.update(student);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void update_testUpdateOfValue_whenValueInputNotUpdated() {
        boolean actual = studentDAOImplementation.update(new Student());
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void update_testUpdateOfValue_whenNullInput() {
        Exception exception = assertThrows(NullPointerException.class,
                () -> studentDAOImplementation.update(null));
        assertEquals("Cannot invoke \"kg.kubatbekov.foxminded.model.Student.getFirst_name()\" because \"student\" is null", exception.getMessage());
    }

    @Test
    void getByName_testGetByName_whenIdInput() {
        Student student = new Student(2, "first_2", "last_2", 1);

        Student actual = studentDAOImplementation.getByName(student.getFirst_name());
        assertEquals(student, actual);
    }

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = studentDAOImplementation.getAll().size();
        assertEquals(109, actual);
    }

    @Test
    void deleteById_testDeleteById_whenThereIsValue() {
        boolean actual = studentDAOImplementation.deleteById(10);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    void deleteById_testDeleteValueById_whenValueNotDeleted() {
        boolean actual = studentDAOImplementation.deleteById(1000);
        boolean expected = false;

        assertEquals(expected, actual);
    }

}
