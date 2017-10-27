package by.tc.task02.DAO.impl;

import by.tc.task02.DAO.EntityDAO;
import by.tc.task02.entity.Entity;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityDAOImpl implements EntityDAO {
    final static private String OPENTAG = "<([^/?])+>";
    final static private String NOTTAG = "[^<].+";
    final static private String CLOUSETAG = "</(\\w|(-))+>";

    @Override
    public Queue<String> createQueue() {
        Queue<String> queue = new ArrayDeque<>();
        parseResourses(queue);
        return queue;
    }

    private void parseResourses(Queue<String> queue) {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("resources/task02.xml").getFile());

        try (final BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file)))){
            String line;
            while ((line = br.readLine()) != null) {
                line = formatLine(line);

                String[] lines = line.split("\n");
                for (String str : lines) {
                    if (!str.isEmpty()) {
                        queue.add(str);
                    }
                }
            }
        }
        catch (IOException ex) {
            System.out.println("Cannot open the file task02.xml");
            ex.printStackTrace();
        }
    }

    private String formatLine(String line) {
        line = line.replaceAll("<^/", "\n<");
        line = line.replaceAll(">", ">\n");
        line = line.replaceAll("</", "\n</");
        return line;
    }

    @Override
    public List<Entity> createListEntity() {
        Queue<String> queue = createQueue();
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
                addOpenTagInList(list, line, level);
                level++;
                continue;
            }

            if (Pattern.matches(CLOUSETAG, line)) {
                level--;
                continue;
            }

            if (!line.isEmpty() && Pattern.matches(NOTTAG, line)) {
                list.get(list.size() - 1).setValue(line);
            }
        }
    }

    private void addOpenTagInList (List<Entity> list, String line, int level) {
        Pattern pat = Pattern.compile(OPENTAG);
        Matcher matcher = pat.matcher(line);
        String str = null;
        if (matcher.find())	{
            str = matcher.group().replaceAll("[<>/]", " ").trim();
        }
        String[] tagWithAttributes = str.split(" ");

        list.add(new Entity(tagWithAttributes[0], level));
        if (tagWithAttributes.length > 1) {
            addAttributeInEntity(list, tagWithAttributes);
        }
    }

    private void addAttributeInEntity(List<Entity> list, String[] tagWithAttributes) {
        for (int i = 1; i < tagWithAttributes.length; i++) {
            String[] str2 = tagWithAttributes[i].split("=");
            list.get(list.size() - 1).addAttribute(str2[0],str2[1]);
        }
    }

    private void introdOfDepend(List<Entity> list) {
        int maxDepth = findMaxDepth(list);

        for (int i = maxDepth; i >= 0; i--) {
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
    }

    private int findMaxDepth(List<Entity> list) {
        int maxDepend = 0;
        for(Entity e : list ) {
            if(maxDepend < e.getLevel()) {
                maxDepend = e.getLevel();
            }
        }
        return maxDepend;
    }
}
