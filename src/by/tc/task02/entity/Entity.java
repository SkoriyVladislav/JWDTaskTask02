package by.tc.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    private List<Entity> list;
    private String tag;
    private String value;
    private int level;

    public Entity(String tag, int level) {
        this.tag = tag;
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addEntity(Entity e) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(e);
    }

    public void addEntity(List<Entity> e) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Entity entity : e) {
            list.add(entity);
        }
    }

    @Override
    public String toString() {
        String str = "[Tag: " + tag + "\t" + "Value: " + value + "\t" + "Level: " + level;
        if (list != null) {
            for (Entity e : list) {
                str = str + e.toString();
            }
        }
        str = str + "]";
        return str;
    }
}
