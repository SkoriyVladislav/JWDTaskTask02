package by.tc.task02.main;

import by.tc.task02.service.EntityListService;
import by.tc.task02.service.ServiceFactory;

import static by.tc.task02.main.PrintXmlFileInfo.print;

public class Main {
    static int i;
    public static void main(String[] agr) {
        ServiceFactory factory = ServiceFactory.getInstance();
        EntityListService service = factory.getEntityService();

        print(service.createListEntity());
    }
}
