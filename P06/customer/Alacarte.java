package customer;
import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Repesents an Alacarte account in the MOES system
 * @author Ashirwad Sharma Dahal
 * @version 1.0
 * @since 2024-09-16
 */ 
public class Alacarte extends Account{
	private int pointsRemaining = 0;

    public Alacarte(){
        super();
    }

    public Alacarte(BufferedReader br) throws IOException{
        super(br);
        pointsRemaining = Integer.parseInt(br.readLine());
    }
    
    /**
     * Adds points for future use
     * @param points the points to be added
     * @since 2024-09-16
     */
	public void buyPoints(int points){
		pointsRemaining += points;
	}
    
    /**
     * Returns the number of remaining points in the account
     * @return the number of remaining points
     * @since 2024-09-16
     */
	public int getPointsRemaining(){
		return pointsRemaining;
	}
    
    /**
     * Plays the specified media if there are enough points
     * @param media the media to be played
     * @return a message indicating whether the media is being played or there are insufficient points
     * @since 2024-09-16
     */ 
	@Override
	public String play(Media media){
        int pointsRequired = media.getPoints();

        if (pointsRemaining >= pointsRequired){
        	pointsRemaining -= pointsRequired;
        	return "Playing: " + media.getTitle() + "(Points Deducted: " + pointsRequired + ")";
        }else{
        	return "Buy more points: Requires :" + pointsRequired + "points, Points you have: " + pointsRemaining;
        }
	}

    public void save(BufferedWriter bw) throws IOException{
        super.save(bw);
        bw.write(String.valueOf(pointsRemaining));
        bw.newLine();
    }
}