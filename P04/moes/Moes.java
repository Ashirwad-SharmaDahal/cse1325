package moes;
import product.Media;
import customer.Student;
import customer.Unlimited;
import customer.Alacarte;
import customer.Account;

import java.util.ArrayList;

public class Moes{
	private ArrayList<Media> library = new ArrayList<>();
	private ArrayList<Student> customers = new ArrayList<>();

    public void addMedia(Media media){
	    library.add(media);
    }

    public String getMediaList(){
        String mediaList = "";
        for(int i = 0; i < library.size(); i++){
    	    Media media = library.get(i);
    	    mediaList += i +")" +media.toString() + "\n";
        }
        return mediaList;
    }

    public void addStudent(Student student){
	    customers.add(student);
    }

    public String getStudentList(){
	    String studentList = "";
	    for(int i = 0; i < customers.size(); i++){
		    Student student = customers.get(i);
		    studentList += i + ")" + student.toString() + "\n";
	    }
	    return studentList;
    }

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

    public String playMedia(int studentIndex, int mediaIndex){
	    Student student = customers.get(studentIndex);
	    Media media = library.get(mediaIndex);
	    return student.getAccount().play(media);
    }
}











