package mdi;
import moes.Moes;
import product.Media;
import customer.Student;
import java.util.Scanner; 
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;

public class Main{
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;
    private boolean dirty;
    private static final String FILE_EXTENSION = ".moes";
    private String filename;
    private static final String MAGIC_COOKIE = "MOES_MAGIC_COOKIE";
    private static final String FILE_VERSION = "1.0";



    public void addStudent() {
    	String name = Menu.getString("Enter Student's name: ", null, null);
        if (name == null || name.trim().isEmpty()) {
        System.out.println("Student's name cannot be empty. Returning to the main menu.");
        return; 
    }
    	 String idInput = Menu.getString("Enter Student's id: ", null, null);
        if (idInput == null || idInput.trim().isEmpty()) {
            System.out.println("Student ID cannot be empty. Returning to the main menu.");
            return; 
        }

        int id;
        try {
            id = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
             System.out.println("Invalid input. Please enter a valid integer for the Student ID.");
            return; 
        }
    	String email = Menu.getString("Enter email: ", null, null);
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Invalid email. Returning to the main menu.");
            return; 
        }
    	String alacarteInput = Menu.getString("Is the account alacarte? true or false: ", null, null);
    	boolean isAlacarte = alacarteInput != null && alacarteInput.equalsIgnoreCase("true");
    	moes.addStudent(new Student(name, id, email, isAlacarte));
    	output = "Student added: " + name;
    	System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

        markDirty();

    }

    public void listStudents(){
        output = moes.getStudentList();
        System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

    }

    private void addMedia(){
    	String title = Menu.getString("Enter media title: ", null, null);
        if (title == null || title.trim().isEmpty()) {
        System.out.println("Media title is empty. Returning to the main menu.");
        return; 
        }
    	String url = Menu.getString("Enter url to the media: ",null, null);
        if (url == null || url.trim().isEmpty()) {
        System.out.println("URL is empty. Returning to the main menu.");
        return; 
        }
    	int points = Menu.getInt("Enter required points to access the media", null, null);
    	moes.addMedia(new Media(title, url, points));
    	output = "Media added: " + title;
    	System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

        markDirty();

    }

    
    private void playMedia() {
    while (true) {
        System.out.println("\n----------------------");
        System.out.println("List of students: " + moes.getStudentList());
        System.out.println("List of media: " + moes.getMediaList());
        System.out.println("\n----------------------");
        
        int studentIndex = Menu.getInt("Enter student index: ", null);
        int mediaIndex = Menu.getInt("Enter media index: ", null);
        
        String studentList = moes.getStudentList();
        String mediaList = moes.getMediaList();

        
        String[] students = studentList.split(", ");
        String[] media = mediaList.split(", ");

        if (studentIndex < 0 || studentIndex >= students.length) {
            System.out.println("Invalid student index! Please choose a valid student from the list.");
            continue; 
        }
        if (mediaIndex < 0 || mediaIndex >= media.length) {
            System.out.println("Invalid media index! Please choose a valid media from the list.");
            continue; 
        }

       
        output = moes.playMedia(studentIndex, mediaIndex);
        System.out.println("\n------------------");
        System.out.println("\n" + output);
        System.out.println("\n------------------");

        String continueChoice = Menu.getString("Do you want to continue playing media? (yes/no): ", null, null);
        if (!continueChoice.equalsIgnoreCase("yes")) {
            System.out.println("Exiting play media.");
            break;
        }
    }
   }


    private void listMedia() {
        output=moes.getMediaList();
        System.out.println("\n------------------");
        System.out.println("\n"+output);
        System.out.println("\n------------------");


}

    private void listAvailablePoints() {
    while (true) {
        int studentIndex = Menu.getInt("Enter student index: ", null);

        int studentCount = moes.getStudentList().split(", ").length; 

        if (studentIndex < 0 || studentIndex >= studentCount) {
            System.out.println("Invalid student index! Please choose a valid student from the list.");
            continue; // Prompt for input again
        }

        output = "Points available: " + moes.getPoints(studentIndex);
        System.out.println("\n------------------");
        System.out.println("\n" + output);
        System.out.println("\n------------------");

        String continueChoice = Menu.getString("Do you want to check points for another student? (yes/no): ", null, null);
        if (!continueChoice.equalsIgnoreCase("yes")) {
            System.out.println("Exiting list available points.");
            break;
        }
    }
  }


    private void buyPoints(){
    	int studentIndex = Menu.getInt("Enter student index: ", null);
    	int currentPoints = moes.getPoints(studentIndex);
    	output = "Current Points: " + currentPoints;
    	System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");


    	int points = menu.getInt("Enter points to buy: ", null);
    	if(points > 0){
    		moes.buyPoints(studentIndex, points);
    		output += "\nNew points: " + moes.getPoints(studentIndex);
    	}else{
    		output = "Cannot buy negative or zero points!";
        }
        System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

    }

    
    public Main(){
    	moes = new Moes();
    	
    	output = "";
    	running = true;
        menu = new Menu();
        dirty = false;

        menu.addMenuItem(new MenuItem("Add Student", () -> addStudent()));
        menu.addMenuItem(new MenuItem("List Students", () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add Media", () -> addMedia()));
        menu.addMenuItem(new MenuItem("List Media", () -> listMedia()));
        menu.addMenuItem(new MenuItem("Play Media", () -> playMedia()));
        menu.addMenuItem(new MenuItem("List Available Points", () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy Points", () -> buyPoints()));
        menu.addMenuItem(new MenuItem("New MOES File", () -> newMoes()));
        menu.addMenuItem(new MenuItem("Save MOES File", () -> save()));
        menu.addMenuItem(new MenuItem("Save MOES File As", () -> saveAs()));
        menu.addMenuItem(new MenuItem("Open MOES File", () -> open()));
        menu.addMenuItem(new MenuItem("Exit", () -> endApp()));   
    }

    private void unsavedChanges(){
            String choose = Menu.getString("You have unsaved changes. Save(yes),discard(no), or cancel(abort)?", null, null);
            if ("yes".equalsIgnoreCase(choose)) {
                save();
            } else if ("no".equalsIgnoreCase(choose)) {
            clearDirty();  // Discard unsaved changes
            } else {
                System.out.println("Operation cancelled.");
            }
    }   

    private void markDirty(){
        dirty = true;
    }

    private void clearDirty(){
        dirty = false;
    }

    public static void main(String[] args){
        displayLogo();
    	Main app = new Main();
    	app.mdi();
    }

     private static void displayLogo() {
       
        System.out.println("-----------------------------------------------");
        System.out.println("| Mavs Online Entertainment System (MOES)     |");
        System.out.println("|                Version 0.3.0                |");
        System.out.println("|           ©2024 Ashirwad Sharma Dahal       |");
        System.out.println("------------------------------------------------");
    }


    private void mdi() {
        while (running == true) {
            output = "";
            start();   
             if (running == false) {
            break;
            }
        }
        System.out.println("Exited the loop. Application will now close.");
    }
    private void start() {    
            menu.startMenu();
    }

    private void endApp() {
        System.out.println("Exiting application...");
        running = false; 
    }

    private void newMoes(){
        if(dirty){
            unsavedChanges();
        }
        moes = new Moes();
        clearDirty();
        System.out.println("Created a new MOES instance");
    }

    private void save(){
        if(filename == null || filename.isEmpty()){
            saveAs();
            return;
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write(MAGIC_COOKIE);
            writer.newLine();
            writer.write(FILE_VERSION);
            writer.newLine();
            moes.save(writer); // Save the MOES data
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

     private void saveAs() {
        System.out.println("Current filename: " + (filename == null ? "None" : filename));
        String newFilename = Menu.getString("Enter new filename: ", null, null);
        if (newFilename == null || newFilename.isEmpty()) {
            System.out.println("No filename provided");
            return;
        }
        if (!newFilename.endsWith(FILE_EXTENSION)) {
            newFilename += FILE_EXTENSION; 
        }
        filename = newFilename;
        save(); 
    }

    private void open() {

        if(dirty){
            unsavedChanges();
        }

        System.out.println("Current filename: " + (filename == null ? "None" : filename));
        String newFilename = Menu.getString("Enter filename to open: ", null, null);
        if (newFilename == null || newFilename.isEmpty()) {
            System.out.println("No filename provided. Cancelled.");
            return;
        }
        if (!newFilename.endsWith(FILE_EXTENSION)) {
            newFilename += FILE_EXTENSION; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(newFilename))) {
            String cookie = reader.readLine();
            if (!MAGIC_COOKIE.equals(cookie)) {
                throw new IOException("Invalid file format (magic cookie mismatch).");
            }
            String version = reader.readLine();
            if (!FILE_VERSION.equals(version)) {
                throw new IOException("Invalid file version.");
            }
            Moes loadedMoes = new Moes(reader); 
            moes = loadedMoes; 
            filename = newFilename;
            clearDirty();
            System.out.println("Data loaded from " + filename);

            listStudents();
            listMedia();
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
       
    }
}   

