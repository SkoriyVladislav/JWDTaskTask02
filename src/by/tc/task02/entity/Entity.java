package by.tc.task02.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
    private List<Entity> list;
    private String tag;
    private String value;
    private int level;
    private Map<String, String> attribute;

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

    public Map<String, String> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String, String> attribute) {
        this.attribute = attribute;
    }

    public List<Entity> getList() {
        return list;
    }

    public void setList(List<Entity> list) {
        this.list = list;
    }

    public void addEntity(List<Entity> e) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Entity entity : e) {
            list.add(entity);
        }
    }

    public void addAttribute(String key, String value) {
        if (attribute == null) {
            attribute = new HashMap<>();
        }
        attribute.put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (level != entity.level) return false;
        if (list != null ? !list.equals(entity.list) : entity.list != null) return false;
        if (tag != null ? !tag.equals(entity.tag) : entity.tag != null) return false;
        if (value != null ? !value.equals(entity.value) : entity.value != null) return false;
        return attribute != null ? attribute.equals(entity.attribute) : entity.attribute == null;
    }

    @Override
    public int hashCode() {
        int result = list != null ? list.hashCode() : 0;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "list=" + list +
                ", tag='" + tag + '\'' +
                ", value='" + value + '\'' +
                ", level=" + level +
                ", attribute=" + attribute +
                '}';
    }
}
