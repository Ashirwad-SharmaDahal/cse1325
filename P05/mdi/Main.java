package mdi;
import moes.Moes;
import product.Media;
import customer.Student;
import java.util.Scanner; 

public class Main{
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;



    public void addStudent(){
    	String name = Menu.getString("Enter Student's name: ", null, null);
    	int id = Menu.getInt("Enter Student's id: ", null, null);
    	String email = Menu.getString("Enter email: ", null, null);
    	String alacarteInput = Menu.getString("Is the account alacarte? true or false: ", null, null);
    	boolean isAlacarte = alacarteInput != null && alacarteInput.equalsIgnoreCase("true");
    	moes.addStudent(new Student(name, id, email, isAlacarte));
    	output = "Student added: " + name;
    	System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

    }

    public void listStudents(){
        output = moes.getStudentList();
        System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

    }

    private void addMedia(){
    	String title = Menu.getString("Enter media title: ", null, null);
    	String url = Menu.getString("Enter url to the media: ",null, null);
    	int points = Menu.getInt("Enter required points to access the media", null, null);
    	moes.addMedia(new Media(title, url, points));
    	output = "Media added: " + title;
    	System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

    }

    /*private void playMedia(){
    	while(true){
    		System.out.println("\n----------------------");
    		System.out.println("List of students: " + moes.getStudentList());
    		System.out.println("List of media: " + moes.getMediaList());
    		System.out.println("\n----------------------");
    		int studentIndex = Menu.getInt("Enter student index: ", null);
      		int mediaIndex = Menu.getInt("Enter media index", null);
      		String studentList = moes.getStudentList();
        	String mediaList = moes.getMediaList();

        	String[] students = studentList.split(", ");
        	String[] media = mediaList.split(", ");

        	if (studentIndex < 1 || studentIndex > students.length) {
            	System.out.println("Invalid student index! Please choose a valid student from the list.");
            	continue; // Prompt for input again
        	}
        	if (mediaIndex < 1 || mediaIndex > media.length) {
            	System.out.println("Invalid media index! Please choose a valid media from the list.");
            	continue; // Prompt for input again
       		}
    		output = moes.playMedia(studentIndex, mediaIndex);
    		System.out.println("\n------------------");
    		System.out.println("\n"+output);
    	    System.out.println("\n------------------");

    	    String continueChoice = Menu.getString("Do you want to continue playing media? (yes/no): ", null, null);
            if (!continueChoice.equalsIgnoreCase("yes")) {
                System.out.println("Exiting play media.");
            break;
            }

    	}    

    }*/
    
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

        // Check if the indices are valid
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


    /*private void playMedia() {
    	System.out.println("Available Students:");
    	System.out.println(moes.getStudentList()); // Assuming this method returns a formatted list of students

    	int studentIndex = Menu.getInt("Enter the student index from the list: ", null);
    	if (studentIndex < 0 || studentIndex >= moes.getStudentList().size()) {
        	System.out.println("Invalid student index! Please choose a valid student from the list.");
        	return; // Exit early if index is out of bounds
    	}

    	System.out.println("Available Media:");
    	System.out.println(moes.getMediaList()); // Assuming this method returns a formatted list of media

    	int mediaIndex = Menu.getInt("Enter the media index from the list: ", null);
    	if (mediaIndex < 0 || mediaIndex >= moes.getMediaList().size()) {
        	System.out.println("Invalid media index! Please choose a valid media from the list.");
        	return; // Exit early if index is out of bounds
    	}

    	output = moes.playMedia(studentIndex, mediaIndex);
    	System.out.println(output); // Display the result of playing the media
    }
    */


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
    		output += "\nNew points" + moes.getPoints(studentIndex);
    	}else{
    		output = "Cannot buy negative or zero points!";
        }
        System.out.println("\n------------------");
    	System.out.println("\n"+output);
    	System.out.println("\n------------------");

    }

    
    public Main(){
    	moes = new Moes();
    	menu = new Menu();
    	output = "";
    	running = true;

        menu.addMenuItem(new MenuItem("Add Student", this::addStudent));
        menu.addMenuItem(new MenuItem("List Students", this::listStudents));
        menu.addMenuItem(new MenuItem("Add Media", this::addMedia));
        menu.addMenuItem(new MenuItem("List Media", this::listMedia));
        menu.addMenuItem(new MenuItem("Play Media", this::playMedia));
        menu.addMenuItem(new MenuItem("List Available Points", this::listAvailablePoints));
        menu.addMenuItem(new MenuItem("Buy Points", this::buyPoints));
        menu.addMenuItem(new MenuItem("Exit", this::endApp));   
    }

    public static void main(String[] args){
    	Main app = new Main();
    	app.mdi();
    }

    private void mdi(){
    	while(running){
    		System.out.println(output);
    		output = "";
    		start();
    	}
    }	
    private void start() {
        menu.startMenu(); 
    }

    private void endApp() {
        System.out.println("Exiting application...");
        running = false; 
    }
    
}