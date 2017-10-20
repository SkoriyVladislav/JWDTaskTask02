package by.tc.task02.DAO.impl;

import by.tc.task02.DAO.EntityDAO;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class EntityDAOImpl implements EntityDAO {
    @Override
    public Queue<String> createQueue() {
        Queue<String> queue = new ArrayDeque<>();
        parseResourses(queue);
        return queue;
    }

    private void parseResourses(Queue<String> queue) {

        try (final BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(new File("src/by/tc/task02/resources"))))){
            String line;
            while ((line = br.readLine()) != null) {

                queue.add(line);
            }
        }
        catch (UnsupportedEncodingException | FileNotFoundException ex) {
            System.out.println("Cannot open the file appliances_db.txt");
            ex.printStackTrace();
            System.exit(0);
        }
        catch (IOException ex) {
            System.out.println("Cannot open the file appliances_db.txt");
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
