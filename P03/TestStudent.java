public class TestStudent{
	public static void main(String[] args){
        int failureCount = 0;

    try{
        Student student = new Student("Ashirwad Dahal", 1002139463, "axs9463@mavs.uta.edu");
        String expected = "Ashirwad Dahal(1002139463, axs9463@mavs.uta.edu, Account #1)";
        String actual = student.toString();
            if(!expected.equals(actual)){
            System.out.println("Fail!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            failureCount++;
        }
    }catch(Exception e){
             System.out.println("Unexpected exception in toString() test: " + e.getMessage());
            failureCount++;
        }

    try{
    	new Student("Ashir Sharma", 1002234232, "asd9453@mavs.uta.edu");
    	System.out.println("FAIL: Exception not thrown for invalid email");
    	failureCount++;
    }catch(IllegalArgumentException e){
    	String expectedMsg = "Non-UTA email";
    	if(!expectedMsg.equals(e.getMessage())){
    		System.out.println("FAIL: Invalid exception message");
    		System.out.println("Expected: " + expectedMsg);
    		System.out.println("Actual: " + e.getMessage());
    		failureCount++;
    	}
    }catch(Exception e){
    	System.out.println("FAIL: incorrect exception type");
    	System.out.println("Expected: IllegalArgumentException");
    	System.out.println("Actual: " + e.getClass().getSimpleName());
    	failureCount++;
        }

    try{
    	Student student = new Student("Ash Dahal", 1227354632, "axd5643@mavs.uta.edu");
    	Media media = new Media("moviecenter", "https://moviecenter.com");
    	String expected = "Playing moviecenter(https://moviecenter.com)";
    	String actual = student.requestMedia(media);

    	if(!expected.equals(actual)){
    		System.out.println("FAIL: requestMedia() method");
    		System.out.println("Expected: " + expected);
    		System.out.println("Actual " + actual);
    		failureCount++;
    	}
    }catch(Exception e){
    		System.out.println("Unexpected exception" + e.getMessage());
    		failureCount++;
    	}
    	
    	System.out.println("Number of failures:" + failureCount);
    }
}

    