import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class FileReader {

	public static void main(String[] args)throws IOException{
		
		//This path will be different 
		File newFile = new File("marksIn.txt");
		File outFile = new File("marksOut.txt");
		
		//Create objects to read and write from files
		Scanner fileScanner = new Scanner(newFile);
		PrintWriter newWriter = new PrintWriter(outFile);
		
		//Vars
		int[] marksArray = new int[20];
		int exceptionCount = 0;
		int count = 0;
		
		//Reads from the file, should a non numeric char be passed, catch the exception.
		while(fileScanner.hasNextLine()){
			try{
				marksArray[count] = fileScanner.nextInt();
				count++;
			}
			catch(Exception InputMismatchException){
				exceptionCount++;
				System.out.println(exceptionCount+" of the lines is/are not (an) integer(s).");
				fileScanner.nextLine();
			}
		}
		
		//Sort it
		Arrays.sort(marksArray);
		
		//Write the sorted array into a file and close the writer.
		for(int i = 0; i<marksArray.length; i++){
			newWriter.println(marksArray[i]);
		}
		newWriter.close();

	}
	
}
