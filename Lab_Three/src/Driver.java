import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* T00548219
 * Kyle Behiels
 */

public class Driver {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		//Define separators for cleanliness and three of each specific derivation of the Animal class
		String seperator = "===========================================";
		String seperatorAlt = "-------------------------------------------";
		Animal elephantOne = new Elephant("trumpet", "walk", "Ellie", 1200);
		Animal elephantTwo = new Elephant("trumpet", "walk", "Ernie", 1132);
		Animal elephantThree = new Elephant("trumpet", "walk", "Edger", 1432);
		Animal hawkOne = new Hawk("shriek", "fly", "Harriette", 4);
		Animal hawkTwo = new Hawk("shriek", "fly", "Harold", 5);
		Animal hawkThree = new Hawk("shriek", "fly", "Harry", 3);
		Animal snakeOne = new Snake("hiss", "slither", "Sammy", 6);
		Animal snakeTwo = new Snake("hiss", "slither", "Susan", 5);
		Animal snakeThree = new Snake("hiss", "slither", "Snakey", 2);
		
		//Create an array containing the "Animal" objects defined above
		Animal[] animalArray = {elephantOne, elephantTwo, elephantThree,hawkOne, hawkTwo, hawkThree, snakeOne, snakeTwo, snakeThree};
		
		//Creates instance of the animal manager class to store the animal array
		Animal_Manager animalManage = new Animal_Manager();
		
		//Calls createAnimalArray from animal manager class
		animalManage.createAnimalArray(animalArray);
		
		System.out.println("Testing Animal_Manage and implementation of serializable.");
		System.out.println(seperator);
		
		animalManage.writeObject(animalManage);
		for(int i = 0; i<((Animal_Manager)animalManage.readObject()).animals.length;i++){
			System.out.println(((Animal_Manager)animalManage.readObject()).animals[i]);
			System.out.println(seperatorAlt);
		}
		
	}
	
	
}
