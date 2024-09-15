package test;
import product.Media;

public class TestMedia{
	public static void main(String[] args){
	    Media media = new Media ("Music Station", "https://musicstation.com", 50);

	String expected = ("Music Station(https://musicstation.com), Points: 50");

	String actual = media.toString();

	if(!expected.equals(actual)){
        System.out.println("FAIL!");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        }
        else{

        }
        //System.out.println(media.toString());
	}
}