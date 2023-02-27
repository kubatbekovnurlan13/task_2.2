package kg.kubatbekov.foxminded.daoTest;

import kg.kubatbekov.foxminded.container.PostgresContainer;
import kg.kubatbekov.foxminded.dao.GroupDAOImplementation;
import kg.kubatbekov.foxminded.model.Group;
import kg.kubatbekov.foxminded.service.ValueInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class GroupDAOImplementationTest extends PostgresContainer {
    @MockBean
    private ValueInput valueInput;
    @Autowired
    private GroupDAOImplementation groupDAOImplementation;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = groupDAOImplementation.getAll().size();
        Assertions.assertEquals(9, actual);
    }

    @Test
    void save_testSave_whenInputNull() {
        Exception exception = assertThrows(NullPointerException.class,
                () -> groupDAOImplementation.save(null));
        Assertions.assertEquals("Cannot invoke \"kg.kubatbekov.foxminded.model.Group.getGroup_name()\" because \"group\" is null", exception.getMessage());
    }

    @Test
    void update_testUpdateOfValue_whenValueInput() {
        Group group = new Group(1, "group_1");

        boolean actual = groupDAOImplementation.update(group);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_testUpdateOfValue_whenValueInputNotUpdated() {
        boolean actual = groupDAOImplementation.update(new Group());
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_testUpdateOfValue_whenNullInput() {
        Exception exception = assertThrows(NullPointerException.class,
                () -> groupDAOImplementation.update(null));
        Assertions.assertEquals("Cannot invoke \"kg.kubatbekov.foxminded.model.Group.getGroup_name()\" because \"group\" is null", exception.getMessage());
    }

    @Test
    void getByName_testGetByName_whenIdInput() {
        Group group = new Group(0, "group_1");

        Group actual = groupDAOImplementation.getByName(group.getGroup_name());
        Assertions.assertEquals(group, actual);
    }

    @Test
    void deleteById_testDeleteById_whenThereIsValue() {
        boolean actual = groupDAOImplementation.deleteById(10);
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteById_testDeleteValueById_whenValueNotDeleted() {
        boolean actual = groupDAOImplementation.deleteById(11);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
}
