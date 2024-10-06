package customer;
import product.Media;
/**
 * Represents an abstract Account class for MOES
 * @author Ashirwad Sharma Dahal
 * @version 1.0
 * @since 2024-09-16
 */
public abstract class Account{
	private int accountNumber;
	private static int nextAccountNumber = 1;

/**
 * Constructs an account object with unique account number
 * @since 2024-09-16
 */
	public Account(){
	    this.accountNumber = nextAccountNumber;
	    nextAccountNumber++;
	}  

/**
 * Returns the account number
 * @return the account number of the account
 * @since 2024-09-16
 */
	public int getAccountNumber(){
	    return accountNumber;
	}

/**
 * Returns the next account number
 * @return the next account number
 * @since 2024-09-16
 */	
	public static int getNextAccountNumber(){
	    return nextAccountNumber;
	}

/**
 * Astract method to handle playing media
 * @param media the media to be played
 * @return a string indicating media being played
 * @since 2024-09-16
 */
	public abstract String play(Media media);
	/*{
		return "Playing " + media.toString();
	}
    */
} 