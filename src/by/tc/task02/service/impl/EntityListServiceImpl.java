package by.tc.task02.service.impl;

import by.tc.task02.DAO.DAOFactory;
import by.tc.task02.DAO.EntityDAO;
import by.tc.task02.entity.Entity;
import by.tc.task02.service.EntityListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EntityListServiceImpl implements EntityListService {
    @Override
    public List<Entity> createListEntity() {
        DAOFactory factory = DAOFactory.getInstance();
        EntityDAO applianceDAO = factory.getEntityDAO();

        Stack<String> stack = applianceDAO.createStack();
        List<Entity> list = new ArrayList<>();


        return list;
    }
}
