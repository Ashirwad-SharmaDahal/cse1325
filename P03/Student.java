public class Student{
	public static void main(String[] args){
	    private String name;
	    private int id;
	    private String email;
	    private Account account;

	    public Student(String name, int id, String email){
	        if(!email.endswith(@uta.edu) || !email.endswith(@mavs.uta.edu)){
	            throw new IllegalArgumentException("Non-UTA email");
	        }
	        this.name = name;
	        this.id = id;
	        this.email = email;
	        this.Account = new account();
	    }

	    public String requestMedia(Media media){
	        return account.play(media);
	    }

	    @Override
	    public String toString(){
	        return name + "(" + id + ", " + email + ", "+ account.getAccountNumber() + ")";
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
}