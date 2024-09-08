public class TestAccount{
	public static void main(String[] args){
	    Account firstaccount = new Account();
	    Account secondaccount = new Account();

	if(firstaccount != 1){
	    System.out.println("FAIL!");
	    System.out.println("Expected: 1");
	    System.out.println("Actual: " + getAccountNumber());
	}

	if(secondaccount != 2){
	System.out.println("FAIL!");
	    System.out.println("Expected: 1");
	    System.out.println("Actual: " + getNextAccountNumber());
	}
	}

}