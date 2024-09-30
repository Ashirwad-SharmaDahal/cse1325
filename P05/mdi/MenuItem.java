package mdi;

public class MenuItem implements Runnable {
    private String menuText; 
    private Runnable action;

    public MenuItem(String menuText, Runnable action) {
        this.menuText = menuText;
        this.action = action;
    }

    @Override
    public String toString() {
        return menuText;
    }

    @Override
    public void run() {
        action.run();
    }
}