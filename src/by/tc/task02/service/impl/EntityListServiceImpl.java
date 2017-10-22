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
    static private String OPENTAG = "<\\w+>";//"<[^/]+>"; //"^.+<[a-z]|[A-Z](.+)>";
    static private String CLOUSETAG = "</\\w+>";

    @Override
    public List<Entity> createListEntity() {
        DAOFactory factory = DAOFactory.getInstance();
        EntityDAO applianceDAO = factory.getEntityDAO();

        Queue<String> queue = applianceDAO.createQueue();
        List<Entity> list = new ArrayList<>();
        initializationList(list,queue);
        introdOfDepend(list);

        return list;
    }

    private void initializationList(List<Entity> list, Queue<String> queue) {
        int level = 0;
        while (queue.peek() != null) {
            String line = queue.poll().trim();

            if (Pattern.matches(OPENTAG, line)) {

                Pattern pat = Pattern.compile(OPENTAG);
                Matcher matcher = pat.matcher(line);
                String str = null;
                if (matcher.find())	{
                    str = matcher.group().replaceAll("<", " ").trim();
                    str = str.replaceAll(">", " ").trim();
                    str = str.replaceAll("/", " ").trim();
                }

                list.add(new Entity(str, level));
                level++;
                continue;
            }

            if (Pattern.matches(CLOUSETAG, line)) {
                level--;
                continue;
            }

            list.get(list.size() - 1).setValue(line);
        }
    }

    private void introdOfDepend(List<Entity> list) {
        int maxDepend = 0;

        for(Entity e : list ) {

            if(maxDepend < e.getLevel()) {

                maxDepend = e.getLevel();
            }
        }

        for (int i = maxDepend; i >= 0; i--) {
            List<Entity> listTemp = null;

            for (int j = list.size() - 1; j >= 0; j--) {

                if (list.get(j).getLevel() == i) {
                    if (listTemp == null) {
                        listTemp = new ArrayList<>();
                    }
                    listTemp.add(list.get(j));
                }

                if (list.get(j).getLevel() == i-1 && listTemp != null) {
                    list.get(j).addEntity(listTemp);
                    listTemp = null;
                }
            }
        }

        /*for (int i = maxDepend; i > 0; i--) {

            for(int j = 0; j < list.size(); j++) {

                if(list.get(j).getLevel() == i) {

                    for (int k = 0; k <= j; k++) {

                        if (list.get(j - k).getLevel() == i - 1) {

                            list.get(j-k).addEntity(list.get(j));
                            break;
                        }
                    }
                }
            }
        }*/

    }
}
