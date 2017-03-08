import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_Handler {

	public static void Write_Bin(Animal inputAnimal) throws IOException{
		FileOutputStream thisStream = new FileOutputStream("animals.dat", true);
		DataOutputStream outputFile = new DataOutputStream(thisStream);
		outputFile.writeUTF(inputAnimal.toString());
		outputFile.close();
	}
	public static String Read_Bin(String fileName) throws IOException{
		boolean endOfFile = false;
		String thisAnimal = "";
		FileInputStream thisStream = new FileInputStream(fileName);
		DataInputStream inputStream = new DataInputStream(thisStream);
		while(!endOfFile){
			try{
				thisAnimal = inputStream.readUTF().toString();
			}
			catch(EOFException e){
				endOfFile = true;
			}
		}
		return thisAnimal;
	}
}
