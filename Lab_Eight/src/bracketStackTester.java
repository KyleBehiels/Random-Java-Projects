import java.util.Scanner;
public class bracketStackTester {

	//Main method for testing bracketStack class
	public static void main(String[] args){
		
		Scanner stringScan = new Scanner(System.in);
		
		System.out.println("Please enter your brackets:");
		bracketStack newStack = new bracketStack(stringScan.nextLine());
		
		if(bracketStack.compareBrackets()){
			System.out.println("Your brackets match!");
		}
		else{
			System.out.println("Your brackets do not match.");
		}
		
	}
	
}
