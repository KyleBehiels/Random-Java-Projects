/* T00548219
 * Kyle Behiels
 */

//Standard class derived from the parent class "Animal"
public class Snake extends Animal{

	//Method from "Sound" interface. Returns animalSound.
	public String getSound(){
		return animalSound;
	}
	//Method from "Sound" interface. Returns animalSound.
	public String getMovement(){
		return animalMovement;
	}
	int length;
	//Constructor, adding the variable "length"
	public Snake(String soundIn, String movementIn, String nameIn, int lengthIn) {
		super(soundIn, movementIn, nameIn);
		length = lengthIn;
	}
	//"setter" method for length
	protected void setLength(int lengthIn){
		length = lengthIn;
	}
	//"getter" method for length
	protected int getLength(){
		return length;
	}
	//Returns a String representation of this particular instance of Snake. Overrides Animals
	//toString() method.
	public String toString(){
		return super.toString()+" Length: "+length+".";
	}
	//Method for checking if this instance of Snake is equal to the parameter Snake. Overrides
	//Animals equals() method.
	public boolean equals(Snake inputAnimal){
		if(super.equals(inputAnimal)&&(inputAnimal.length == (this.length))){
			return true;
		}
		else
			return false;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
