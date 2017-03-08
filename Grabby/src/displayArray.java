/*
 * Class that handles directories in a Array 
 * for use with the display panes
 */
public class displayArray {
	
	//=======================================--------Variables
	public static String[] displayArray = new String[10];
	private static int index = 0;
	//=======================================
	
	//=======================================--------Adds a string to the array
	public static void add(String input){
		if(!(index == displayArray.length-1)){
			displayArray[index] = input;
			index++;
		}
		else{
			expand();
			displayArray[index] = input;
			index++;
		}
	}
	//=======================================
	
	//=======================================--------Expands the array when full
	public static void expand(){
		String[] tempArray = displayArray;
		displayArray = new String[tempArray.length*2];
		for(int i = 0; i<tempArray.length;i++){
			displayArray[i] = tempArray[i];
		}
	}
	//=======================================
	
	//=======================================--------Resets the array
	public static void clear(){
		displayArray = new String[10];
	}
	//=======================================
}
