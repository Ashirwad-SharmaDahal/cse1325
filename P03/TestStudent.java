public class TestStudent{
	public static void main(String[] args){
        int failureCount = 0;

    try{
        Student student = new Student("Ashirwad Dahal", 1002139463, "axs9463@mavs.uta.edu");
        String expected = "Ashirwad Dahal(1002139463, axs9463@mavs.uta.edu, Account #1)";
        String actual = student.toString();
            if(!expected.equals(actual)){
            System.out.print("Fail!");
            System.out.print("Expected: " + expected);
            System.out.print("Actual: " + actual);
            failureCount++;
        }
        }catch(Exception e){
             System.out.println("Unexpected exception in toString() test: " + e.getMessage());
            failureCount++;

        }
	}
}