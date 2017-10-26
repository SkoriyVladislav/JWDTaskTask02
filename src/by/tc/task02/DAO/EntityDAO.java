package by.tc.task02.DAO;

import by.tc.task02.entity.Entity;

import java.util.List;
import java.util.Queue;

public interface EntityDAO {
    Queue<String> createQueue();
    List<Entity> createListEntity();
}
