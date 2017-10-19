package by.tc.task02.service;

import by.tc.task02.service.impl.EntityListServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final EntityListService entityListService = new EntityListServiceImpl();

    private ServiceFactory() {

    }

    public EntityListService getEntityService() {
        return entityListService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}
