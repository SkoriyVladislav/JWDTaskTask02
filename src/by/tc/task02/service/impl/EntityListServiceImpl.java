package by.tc.task02.service.impl;

import by.tc.task02.DAO.DAOFactory;
import by.tc.task02.DAO.EntityDAO;
import by.tc.task02.entity.Entity;
import by.tc.task02.service.EntityListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EntityListServiceImpl implements EntityListService {
    @Override
    public List<Entity> createListEntity() {
        DAOFactory factory = DAOFactory.getInstance();
        EntityDAO applianceDAO = factory.getEntityDAO();

        Queue<String> queue = applianceDAO.createQueue();
        List<Entity> list = new ArrayList<>();
        initializationList(list,queue);

        return list;
    }

    private void initializationList(List<Entity> list, Queue<String> queue) {
        while (queue.peek() != null) {
            String str = queue.poll();

        }
    }
}
