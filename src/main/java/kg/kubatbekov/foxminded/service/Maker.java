package kg.kubatbekov.foxminded.service;

import kg.kubatbekov.foxminded.dao.GroupDAOImplementation;
import kg.kubatbekov.foxminded.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Maker {
    private JdbcTemplate jdbcTemplate;
    private Group group;
    private GroupDAOImplementation groupDAOImplementation;

    @Autowired
    public Maker(JdbcTemplate jdbcTemplate,
                 Group group,
                 GroupDAOImplementation groupDAOImplementation) {
        this.jdbcTemplate = jdbcTemplate;
        this.group = group;
        this.groupDAOImplementation = groupDAOImplementation;
        doSomeStuff();
    }

    public void doSomeStuff(){
        group.setGroup_name("new group name 4");
        groupDAOImplementation.save(group);
    }
}
