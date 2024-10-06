package customer;
import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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

	public Account(BufferedReader br) throws IOException{
		this.accountNumber = Integer.parseInt(br.readLine());
		nextAccountNumber = Integer.parseInt(br.readLine());
	}

	public void save(BufferedWriter bw) throws IOException{
		bw.write(Integer.toString(accountNumber) + '\n');
		bw.write(Integer.toString(nextAccountNumber) + '\n');
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