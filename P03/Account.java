public class Account{
	private int accountNumber;
	private static int nextAccountNumber = 1;

	public Account(){
	    this.accountNumber = nextAccountNumber;
	    nextAccountNumber++;
	}  

	public int getAccountNumber(){
	    return accountNumber;
	}
	
	public static int getNextAccountNumber(){
	    return nextAccountNumber;
	}

	public String play(Media media){
		return "Playing " + media.toString();
	}

}