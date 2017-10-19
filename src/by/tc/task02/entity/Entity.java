package by.tc.task02.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
    private List<Entity> list;
    private String tag;
    private Map<String, String> attributes;
    private int level;

    public Entity(String tag, int level) {
        this.tag = tag;
        this.level = level;
    }

    /* public Entity(Entity e, int lvl){
        list = new ArrayList<>();
        list.add(e);
        this.level = lvl;
    }

    public Entity(String tag, String info, int lvl) {
        attributes = new HashMap<>();
        attributes.put(tag,info);
        this.level = lvl;
    } */

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

    public void addAttributes(String tag, String info) {
        if (attributes == null) {
            attributes = new HashMap<>();
        }
        attributes.put(tag,info);
    }

    public void addEntity(Entity e) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(e);
    }

}
