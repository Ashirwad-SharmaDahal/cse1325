package customer;
import product.Media;

/**
 * Represents an unlimited account in the MOES system
 * @author Ashirwad Sharma Dahal
 * @version 1.0
 * @since 2024-09-16
 */
public class Unlimited extends Account{

	/**
	 * Plays the specified media for an unlimited account
	 * @param media the media to be played
	 * @return a string indication the media is being played
	 * @since 2024-09-16
	 */
	@Override
	public String play(Media media){
        return "Playing: " + media.toString();
	}
}