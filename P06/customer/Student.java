package customer;
import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Student{
	    private String name;
	    private int id;
	    private String email;
	    private Account account;

	    public Student(String name, int id, String email, boolean isAlacarte){
	        if(!email.endsWith("@uta.edu") || !email.endsWith("@mavs.uta.edu")){
	        this.name = name;
	        this.id = id;
	        this.email = email;
	        if (isAlacarte){
	            this.account = new Alacarte();
	        }else{
	        	this.account = new Unlimited();
	        }
	    }else{
	    	    throw new IllegalArgumentException("Non-UTA email");
	    }
	    }

	    public Student(BufferedReader br) throws IOException{
	    	this.name = br.readLine();
	    	this.id = Integer.parseInt(br.readLine());
	    	this.email = br.readLine();

	    	String accountClass = br.readLine();
	    	switch(accountClass){
	    	case "customer.Alacarte":
	    		this.account = new Alacarte(br);
	    		break;
	    	case "customer.Unlimited":
	    	    this.account = new Unlimited(br);
	    	    break;
	    	default:
	    	    throw new IOException("Unknown account: " + accountClass);    	
	    	}
	    }

	    public void save(BufferedWriter bw) throws IOException{
	    	bw.write(name);
	    	bw.newLine();
	    	bw.write(String.valueOf(id));
	    	bw.newLine();
	    	bw.write(email);
	    	bw.newLine();

	    	bw.write(account.getClass().getName());
	    	bw.newLine();

	    	account.save(bw);
	    }

	    public String requestMedia(Media media){
	        return account.play(media);
	    }

	    @Override
	    public String toString(){
	        return name + "(" + id + ", " + email + ", "+ "Account #" + account.getAccountNumber() + ")";
	    }

	    public String getName(){
	       return name;
	    }

	    public int getId(){
	        return id;
	    }

	    public String getEmail(){
	        return email;
	    }

	    public Account getAccount(){
	        return account;
	    }
	}