public class Student{
	    private String name;
	    private int id;
	    private String email;
	    private Account account;

	    public Student(String name, int id, String email){
	        if(!email.endsWith("@uta.edu") || !email.endsWith("@mavs.uta.edu")){
	            throw new IllegalArgumentException("Non-UTA email");
	        }
	        this.name = name;
	        this.id = id;
	        this.email = email;
	        this.account = new Account();
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