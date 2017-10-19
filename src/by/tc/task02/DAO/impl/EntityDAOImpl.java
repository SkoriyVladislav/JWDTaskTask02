package by.tc.task02.DAO.impl;

import by.tc.task02.DAO.EntityDAO;

import java.util.ArrayDeque;
import java.util.Queue;

public class EntityDAOImpl implements EntityDAO {
    @Override
    public Queue<String> createQueue() {
        Queue<String> Queue = new ArrayDeque<>();

        return Queue;
    }
}
