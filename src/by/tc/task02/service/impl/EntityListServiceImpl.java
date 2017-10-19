package by.tc.task02.service.impl;

import by.tc.task02.DAO.DAOFactory;
import by.tc.task02.DAO.EntityDAO;
import by.tc.task02.entity.Entity;
import by.tc.task02.service.EntityListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityListServiceImpl implements EntityListService {
    static private String OPENTAG = "<[a-z]|[A-Z]>";
    static private String CLOUSETAG = "</[a-z]|[A-Z]>";

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
        int level = 0;
        while (queue.peek() != null) {
            String line = queue.poll();

            if (Pattern.matches(OPENTAG, line)) {

                Pattern pat = Pattern.compile(OPENTAG);
                Matcher matcher = pat.matcher(line);
                String str = null;
                if (matcher.find())	{
                    str = matcher.group().replaceAll("< | >", " ").trim();
                }

                list.add(new Entity(str, level));
                level++;
                continue;
            }

            if (Pattern.matches(CLOUSETAG, line)) {
                level--;
                continue;
            }

            list.get(list.size()).setValue(line);
        }
    }
}
