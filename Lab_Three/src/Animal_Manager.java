import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Class for managing an array of animals to be written to file

public class Animal_Manager implements Serializable{
	
	Animal[] animals;
	
	//Assigns passed value to array animals
	public void createAnimalArray(Animal[] inputArray){
		animals = inputArray;
	}
	
	//Method for retrieving animal array
	public Animal[] getAnimalArray(){
		return animals;
	}
	
	public static void writeObject(Object inputObject) throws IOException{
		FileOutputStream fileOutput = new FileOutputStream("Animals.dat");
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOutput);
		objectOut.writeObject(inputObject);
	}
	public static Object readObject() throws ClassNotFoundException, IOException{
		FileInputStream fileInput = new FileInputStream("Animals.dat");
		ObjectInputStream objectIn = new ObjectInputStream(fileInput);
		return objectIn.readObject();
	}

}
