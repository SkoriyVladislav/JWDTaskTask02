package by.tc.task02.main;

import by.tc.task02.service.EntityListService;
import by.tc.task02.service.ServiceFactory;

public class main {
    public static void main(String... agr) {
        ServiceFactory factory = ServiceFactory.getInstance();
        EntityListService service = factory.getEntityService();

        System.out.println(service.createListEntity());
    }
}
