/* T00548219
 * Kyle Behiels
 */

//Abstract class designed as a parent for other animal classes.
public abstract class Animal {
	//Variables consistent with all animals to be derived from this parent.
	protected String animalSound, animalMovement, animalName;
	
	//Constructor 
	public Animal(String soundIn, String movementIn, String nameIn){
		animalSound = soundIn;
		animalMovement = movementIn;
		animalName = nameIn;
	}
	//"getter" method for animalSound
	protected String sound(){
		return animalSound;
	}
	//"getter" method for animalMovement
	protected String movement(){
		return animalMovement;
	}
	//Method that returns a string representation of this instance of Animal.
	public String toString(){
		return "Sound: "+ animalSound+". Movement: "+animalMovement+". Name: "+animalName+".";
	}
	//"getter" method for animalName
	public String getName(){
		return animalName;
	}
	//"setter" method for animalName
	public void setName(String nameIn){
		animalName = nameIn;
	}
	//Method for comparing one Animal instance to another.
	public boolean equals(Animal inputAnimal){
		if((animalSound.equals(inputAnimal.animalSound))&&(animalMovement.equals(inputAnimal.animalMovement))&&(animalName.equals(inputAnimal.animalName))){
			return true;
		}
		else
			return false;
	}
}
