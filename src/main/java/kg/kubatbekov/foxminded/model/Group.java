package kg.kubatbekov.foxminded.model;

import org.springframework.stereotype.Component;

@Component
public class Group {
    private int group_id;
    private String group_name;

    public Group() {
    }

    public Group(int group_id, String group_name) {
        this.group_id = group_id;
        this.group_name = group_name;
    }

    public int getGroup_id() {
        return group_id;
    }

    public Group(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    @Override
    public String toString() {
        return "Group: " +
                "group_id=" + group_id +
                ", group_name='" + group_name;
    }
}
