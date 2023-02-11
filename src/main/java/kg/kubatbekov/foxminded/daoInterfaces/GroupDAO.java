package kg.kubatbekov.foxminded.daoInterfaces;

import kg.kubatbekov.foxminded.model.Group;

import java.util.List;

public interface GroupDAO {
    void save(Group group);

    boolean update(Group group);

    Group getByName(String name);

    List<Group> getAll();

    boolean deleteById(int group_id);

}
