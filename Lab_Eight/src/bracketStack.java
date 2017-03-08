import java.util.*;

public class bracketStack {
	
	static String userInput;
	static Stack bracketStack = new Stack();
	
	//Constructor, accepts "input" String
	public bracketStack(String input){
		userInput = input;
	}
	
	//Method that checks if a specific char is a open bracket
	public static boolean checkOpen(char input){
		
		switch(input){
		case '{':
			return true;
		case '[':
			return true;
		case '(':
			return true;
		default:
			return false;
			
		}
		
	}
	
	//Method that takes a string and turns all closed brackets into open ones for comparison
	public static String reverseBrackets(String closedBrackets){
		
		String reversed = "";
		for(int i = 0; i< closedBrackets.length(); i++){
			switch(closedBrackets.charAt(i)){
			case '}':
				reversed = reversed+"{";
				break;
			case ']':
				reversed = reversed+"[";
				break;
			case ')':
				reversed = reversed+"(";
				break;
			}
		}
		return reversed;
		
	}
	
	//Method for removing and documenting unwanted chars inside a String of brackets
	public static String removeUnwanted(String inputBrackets){
		String noWhiteString = "";
		String problemChars = "";
		for(int i = 0; i<inputBrackets.length();i++){
			if((inputBrackets.charAt(i)=='(')||(inputBrackets.charAt(i)==')')||(inputBrackets.charAt(i)=='[')||(inputBrackets.charAt(i)==']')||(inputBrackets.charAt(i)=='{')||(inputBrackets.charAt(i)=='}')){
				noWhiteString = noWhiteString+inputBrackets.charAt(i);
			}
			else if(!(inputBrackets.charAt(i)==' ')){
				problemChars = problemChars + inputBrackets.charAt(i)+", ";
			}
		}
		System.out.println("Removed the following characters: "+problemChars);
		return noWhiteString;
	}
	
	//Method for checking if a string has matching open and closed brackets
	public static boolean compareBrackets(){
		boolean stop = false;
		String input = removeUnwanted(userInput);
		int index = 0;
		char compareChar;
		
		while(checkOpen(input.charAt(index))){
			bracketStack.push(input.charAt(index));
			index++;
		}
		String closedBrackets = input.substring(index);
		closedBrackets = reverseBrackets(closedBrackets);
		for(int i = 0; i < closedBrackets.length();i++){
			compareChar = (char) bracketStack.pop();
			if(!(compareChar == closedBrackets.charAt(i))){
				return false;
			}
		}
		
		return true;
		
	}
	

}
