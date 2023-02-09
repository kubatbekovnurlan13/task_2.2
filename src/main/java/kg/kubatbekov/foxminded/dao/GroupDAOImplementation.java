package kg.kubatbekov.foxminded.dao;

import kg.kubatbekov.foxminded.daoInterfaces.GroupDAO;
import kg.kubatbekov.foxminded.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDAOImplementation implements GroupDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GroupDAOImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Group group) {
        String SQL_SAVE = "insert into groups (group_name) VALUES (?);";
        jdbcTemplate.update(SQL_SAVE, group.getGroup_name());
    }

    @Override
    public boolean update(Group group) {
        String SQL_UPDATE = "update groups set group_name=? where group_id=?;";
        return 0 < jdbcTemplate.update(SQL_UPDATE,
                group.getGroup_name(),
                group.getGroup_id());
    }

    @Override
    public Group getById(int group_id) {
        Group group = new Group();
        String SQL_GET = "select * from groups where group_id=?;";
        return jdbcTemplate.query(SQL_GET, new Object[]{group_id}, new BeanPropertyRowMapper<>(Group.class))
                .stream().findAny().orElse(group);
    }

    @Override
    public List<Group> getAll() {
        String SQL_GETALL = "select * from groups;";
        return jdbcTemplate.query(SQL_GETALL, new BeanPropertyRowMapper<>(Group.class));
    }

    @Override
    public boolean deleteById(int group_id) {
        String SQL_DELETE = "delete from groups where group_id=?;";
        return 0 < jdbcTemplate.update(SQL_DELETE, group_id);
    }
}
