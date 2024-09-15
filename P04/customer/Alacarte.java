package customer;
import product.Media;

public class Alacarte extends Account{
	private int pointsRemaining = 0;

	public void buyPoints(int points){
		pointsRemaining += points;
	}

	public int getPointsRemaining(){
		return pointsRemaining;
	}

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
}