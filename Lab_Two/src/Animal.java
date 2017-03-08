/*
 * Kyle Behiels
 * T00548219
 */

//Basic abstract parent class

public abstract class Animal {
	
	//Variables for animals sound and movement
	protected String animalSound, animalMovement;
	
	//Constructor for initiating and assigning values to animalSound and animalMovement
	public Animal(String soundIn, String movementIn){
		animalSound = soundIn;
		animalMovement = movementIn;
	}
	
	//Method that when called returns the value of animalSound
	protected String sound(){
		return animalSound;
	}
	
	//Method that when called returns the value of animalMovement
	protected String movement(){
		return animalMovement;
	}
	
	//Method that returns a string representation of this particular instance of animal. Overrides java.object.toString
	public String toString(){
		return "Sound: "+ animalSound+". Movement: "+animalMovement+".";
	}

	/* Returns a boolean. Returns true if the values in parameter inputAnimal are identical to the values of the variables in this 
	 * particular instance of animal. Else returns false. */
	public boolean equals(Animal inputAnimal){
		if((animalSound.equals(inputAnimal.animalSound))&&(animalMovement.equals(inputAnimal.animalMovement))){
			return true;
		}
		else
			return false;
	}
}
