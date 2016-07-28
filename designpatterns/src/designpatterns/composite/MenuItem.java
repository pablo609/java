package designpatterns.composite;

public class MenuItem implements Component {
    private String name;
    private int level;

    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void display() {
        for(int i = 1; i <= level; ++i) {
            System.out.print(" ");
        }

        System.out.println(name);
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
