package designpatterns.composite;

import java.util.ArrayList;

public class Menu implements Composite {
    private ArrayList<Component> menuItems = new ArrayList<Component>();
    private String name;
    private int level;

    public Menu(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void add(Component component) {
        if(component instanceof MenuItem) {
            ((MenuItem) component).setLevel(level + 1);
        }

        menuItems.add(component);
    }

    public void display() {
        for(int i = 1; i <= level; ++i) {
            System.out.print(" ");
        }
        System.out.println(name);

        for(Component menuItem : menuItems) {
            menuItem.display();
        }
    }
}

