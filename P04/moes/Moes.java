package moes;
import product.Media;
import customer.Student;
import customer.Unlimited;
import customer.Alacarte;
import customer.Account;

import java.util.ArrayList;
/**
 * It is the interface class to the customer and product packages.
 * @author Ashirwad Sharma Dahal
 * @version 1.0
 * @since 2024-09-16
 */
public class Moes{
	private ArrayList<Media> library = new ArrayList<>();
	private ArrayList<Student> customers = new ArrayList<>();

/**
 * Adds a media item to MOES library
 * @param media the media item to be added to the library
 * @since 2024-09-16
 */
    public void addMedia(Media media){
	    library.add(media);
    }

/**
 * Retrieves a list of all media items.
 * @return a formatted string of media items
 * @since 2024-09-16
 */
    public String getMediaList(){
        String mediaList = "";
        for(int i = 0; i < library.size(); i++){
    	    Media media = library.get(i);
    	    mediaList += i +")" +media.toString() + "\n";
        }
        return mediaList;
    }

/**
 * Adds a student to MOES system
 * @param student the student to be added
 * @since 2024-09-16
 */
    public void addStudent(Student student){
	    customers.add(student);
    }

/**
 * Retrieves a list of all Students 
 * @return a list of students
 * @since 2024-09-16
 */
    public String getStudentList(){
	    String studentList = "";
	    for(int i = 0; i < customers.size(); i++){
		    Student student = customers.get(i);
		    studentList += i + ")" + student.toString() + "\n";
	    }
	    return studentList;
    }

/**
 * Retrieves the number of points available to a particular student
 * @param studentIndex the index of the student in the customer list
 * @return the number of points available to the student
 * @since 2024-09-16
 */
    public int getPoints(int studentIndex){
	    Account account = customers.get(studentIndex).getAccount();
	    if(account instanceof Alacarte){
		    return ((Alacarte) account).getPointsRemaining();
	    }else if(account instanceof Unlimited) {
            return Integer.MAX_VALUE;
	    }else{
		    throw new UnsupportedOperationException("Unknown subclass of Account");
	    }
    }
/**
 * Adds points to the account of student
 * @param studentIndex the index of the student in the customer list
 * @param points the number of points to add
 * @return the number of points added
 * @since 2024-09-16
 */
    public String buyPoints(int studentIndex, int points){
	     Account account = customers.get(studentIndex).getAccount();
	    if(account instanceof Alacarte){
		    Alacarte alacarteAccount = (Alacarte) account;
		    return "Points added. Total points now: " + alacarteAccount;
	    }else if(account instanceof Unlimited){
		    return "Unlimited Account. Do not need any additional points";
	    }else{
		    throw new UnsupportedOperationException("Unknown subclass of Account");
	    }
    }

/**
 * Allows the student to play the media
 * @param studentIndex the index of the student in the customer list
 * @param mediaIndex the index of media in the library
 * @return message indicating media playback
 * @since 2024-09-16
 */
    public String playMedia(int studentIndex, int mediaIndex){
	    Student student = customers.get(studentIndex);
	    Media media = library.get(mediaIndex);
	    return student.getAccount().play(media);
    }
}











