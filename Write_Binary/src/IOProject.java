import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOProject {

	public static void main(String[] args) throws IOException{
		File_Handler thisManager = new File_Handler();
		Elephant Ellie = new Elephant("Trumpet","Walk", "Ellie", 2000);
		
		System.out.println("Writing to file.");
		System.out.println("-----------------------------------------------------------------");
		thisManager.Write_Bin(Ellie);
		System.out.println("Reading from file.");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(thisManager.Read_Bin("animals.dat"));
		System.out.println("-----------------------------------------------------------------");
	}
	
}
