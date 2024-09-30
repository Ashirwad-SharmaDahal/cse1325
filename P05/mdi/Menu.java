package mdi;

import mdi.MenuItem; // Import your MenuItem class
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private List<MenuItem> items = new ArrayList<>();
    private static Scanner in = new Scanner(System.in); // Declare Scanner

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu:\n");
        for (int i = 0; i < items.size(); ++i) {
            sb.append((i + 1) + "] " + items.get(i) + "\n"); // 1-based index for user friendliness
        }
        return sb.toString();
    }

    public void display() {
        System.out.println(this); // Print the menu
    }

    public void run(int itemNumber) {
        items.get(itemNumber - 1).run(); // Adjust for 1-based index
    }

    public void startMenu() {
        while (true) {
            display(); // Show the menu
            int choice = getInt("Choose an option (1 to " + items.size() + "): ", null);
            if (choice < 1 || choice > items.size()) {
                System.out.println("Invalid choice. Please try again.");
            } else if (choice == items.size()) {
                System.out.println("Exiting...");
                break; // Exit the loop if user chooses the exit option
            } else {
                run(choice); // Run the selected menu item
            }
        }
    }

    public static String getString(String prompt, String cancelInput, String defaultInput) {
        String s = null;
        while (true) {
            try {
                System.out.print(prompt);
                s = in.nextLine().trim(); // Use the declared Scanner
                if (s.isEmpty() && defaultInput != null) s = defaultInput;
                break;
            } catch (Exception e) {
                System.err.println("Invalid input!");
            }
        }
        if (cancelInput != null && s.equals(cancelInput)) s = null;
        return s;
    }

    public static Integer getInt(String prompt, String cancelInput, String defaultInput) {
        Integer i = null;
        while (true) {
            try {
                String s = getString(prompt, cancelInput, defaultInput);
                if (s != null && !s.isEmpty()) i = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return i;
    }

    public static Integer getInt(String prompt, String cancelInput) {
        return getInt(prompt, cancelInput, null);
    }

    public static Integer getInt(String prompt) {
        return getInt(prompt, null, null);
    }
}
