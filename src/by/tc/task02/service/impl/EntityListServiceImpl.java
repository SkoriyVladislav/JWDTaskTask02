package by.tc.task02.service.impl;

import by.tc.task02.DAO.DAOFactory;
import by.tc.task02.DAO.EntityDAO;
import by.tc.task02.entity.Entity;
import by.tc.task02.service.EntityListService;

import java.util.List;

public class EntityListServiceImpl implements EntityListService {

    @Override
    public List<Entity> createListEntity() {
        DAOFactory factory = DAOFactory.getInstance();
        EntityDAO applianceDAO = factory.getEntityDAO();

        List<Entity> list = applianceDAO.createListEntity();

        return list;
    }
}
