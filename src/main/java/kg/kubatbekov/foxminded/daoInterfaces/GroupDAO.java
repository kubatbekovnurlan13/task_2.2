package kg.kubatbekov.foxminded.daoInterfaces;

import kg.kubatbekov.foxminded.model.Group;

import java.util.List;

public interface GroupDAO {
    void save(Group group);

    boolean update(Group group);

    Group getById(int group_id);

    List<Group> getAll();

    boolean deleteById(int group_id);

}
