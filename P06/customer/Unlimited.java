package customer;
import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents an unlimited account in the MOES system
 * @author Ashirwad Sharma Dahal
 * @version 1.0
 * @since 2024-09-16
 */
public class Unlimited extends Account{

	public Unlimited(){
		super();
	}

	public Unlimited(BufferedReader br) throws IOException{
		super(br);
	}

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
    @Override
	public void save(BufferedWriter bw) throws IOException{
		super.save(bw);
	}
}