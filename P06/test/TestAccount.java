package test;
import customer.Unlimited;
import product.Media;

public class TestAccount{
	public static void main(String[] args){
	    Unlimited firstaccount = new Unlimited();
	    Unlimited nextaccount = new Unlimited();

	if(firstaccount.getAccountNumber() != 1){
	    System.out.println("FAIL!");
	    System.out.println("Expected: 1");
	    System.out.println("Actual: " + firstaccount.getAccountNumber());
	    System.exit(1);
	}

	if(nextaccount.getAccountNumber() != 2){
	System.out.println("FAIL!");
	    System.out.println("Expected: 2");
	    System.out.println("Actual: " + nextaccount.getAccountNumber());
	    System.exit(1);
	}
	}

}
