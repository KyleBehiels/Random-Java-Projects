import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.midi.Instrument;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class StacksAndQueues {
	
	/*
	 * Everything is running well except for the drop out stack. Get your life together and implement it
	 */
	
	public final static String seperator = "=====================================================";
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * Start testing the drop out stack
		 * =======================================================
		 */
		

		/*
		 * Finished testing the drop out stack
		 * =======================================================
		 */
		
		/*
		 * Start testing the deque 
		 * =======================================================
		 */
		
		myDeque<String> test2 = new myDeque<>();
		System.out.println(seperator);
		System.out.println("Begin testing myDeque");
		System.out.println(seperator);
		System.out.println("Size = "+test2.size());
		System.out.println(test2.toString());
		System.out.println("Pushing string 'Hello' to end");
		test2.pushEnd("Hello");
		System.out.println("Peek end = "+test2.peekEnd());
		System.out.println("Peek start = "+test2.peekStart());
		System.out.println("Size = "+test2.size());
		System.out.println(test2.toString());
		System.out.println("Pushing string 'Goodbye' to the end");
		test2.pushEnd("Goodbye");
		System.out.println("Peek end = "+test2.peekEnd());
		System.out.println("Peek start = "+test2.peekStart());
		System.out.println("Size = "+test2.size());
		System.out.println(test2.toString());
		System.out.println("Pushing string 'foo' to the start");
		test2.pushStart("foo");
		System.out.println("Pushing string 'bar' to the start");
		test2.pushStart("bar");
		System.out.println("Peek end = "+test2.peekEnd());
		System.out.println("Peek start = "+test2.peekStart());
		System.out.println("Size = "+test2.size());
		System.out.println(test2.toString());
		System.out.println("Pop from end = "+test2.popEnd());
		System.out.println("Size = "+test2.size());
		System.out.println(test2.toString());
		System.out.println("Pop from start = "+test2.popStart());
		System.out.println("Size = "+test2.size());
		System.out.println(test2.toString());
		System.out.println(seperator);
		System.out.println("Finish testing myDeque");
		System.out.println(seperator);
		System.out.println(seperator);
		System.out.println("Begin testing palindrome");
		System.out.println(seperator);
		
		String testString1 = "hello",
				testString2 = "helloolleh",
				testString3 = "testinggnitset";
		
		if(isPalindrome(testString1)){
			System.out.println(testString1+" is a palindrome.");
		}
		else{
			System.out.println(testString1+" is not a palindrome.");
		}
		if(isPalindrome(testString2)){
			System.out.println(testString2+" is a palindrome.");
		}
		else{
			System.out.println(testString2+" is not a palindrome.");
		}
		if(isPalindrome(testString3)){
			System.out.println(testString3+" is a palindrome.");
		}
		else{
			System.out.println(testString3+" is not a palindrome.");
		}
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(seperator);
		System.out.println("Try your own! Type \"no\" to cancel.");
		
		String userInput = scanner.nextLine();
		
		if(!(userInput.equals("no"))){
			if(isPalindrome(userInput)){
				System.out.println(userInput+" is a palindrome!");
			}
			else{
				System.out.println(userInput+" is not a palindrome...");
			}
		}
		
		
		
	}
	
	public static boolean isPalindrome(String input){
		Queue<Character> inputStringQueue = new LinkedList<>();
		Stack<Character> inputStringStack = new Stack<Character>();
		for(int i = 0; i< input.length(); i++){
			inputStringQueue.offer(input.charAt(i));
			inputStringStack.push(input.charAt(i));
		}
		for(int i = 0; i<input.length(); i++){
			char currentChar = inputStringQueue.poll();
			if(!(currentChar==inputStringStack.pop())){
				return false;
			}
		}
		return true;
	}
	
}








