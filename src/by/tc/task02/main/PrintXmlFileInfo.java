package by.tc.task02.main;

import by.tc.task02.entity.Entity;

import java.util.List;

public class PrintXmlFileInfo {
    public static void print(List<Entity> list) {
        print(list.get(0));
    }

    private static void print(Entity e) {
        System.out.println();

        printTab(e);
        if (e.getAttribute() == null) {
            System.out.print(e.getTag() + ": ");
        } else {
            System.out.print(e.getTag() + e.getAttribute() + ": ");
        }
        if (e.getValue() != null) {
            System.out.print(e.getValue());
        }
        if (e.getList() != null) {
            List<Entity> innerList = e.getList();
            for (Entity entity : innerList) {
                print(entity);
            }
        }
    }

    private static void printTab(Entity e) {
        for (int i = 0; i < e.getLevel(); i++) {
            System.out.print("\t");
        }
    }
}
