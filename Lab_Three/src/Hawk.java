/* T00548219
 * Kyle Behiels
 */

//Standard class derived from the parent class "Animal"
public class Hawk extends Animal{

	//Method from "Sound" interface. Returns animalSound.
	public String getSound(){
		return animalSound;
	}
	//Method from "Sound" interface. Returns animalSound.
	public String getMovement(){
		return animalMovement;
	}
	
	int wingSpan;
	//Constructor, adding the variable "wingSpan"
	public Hawk(String soundIn, String movementIn, String nameIn, int wingsIn) {
		super(soundIn, movementIn, nameIn);
		wingSpan = wingsIn;
	}
	//"setter" method for wingSpan
	protected void setWingspan(int wingsIn){
		wingSpan = wingsIn;
	}
	//"getter" method for wingSpan
	protected int getWingspan(){
		return wingSpan;
	}
	//Returns a String representation of this particular instance of Hawk. Overrides Animals
	//toString() method.
	public String toString(){
		return super.toString()+" Wingspan: "+wingSpan+".";
	}
	//Method for checking if this instance of Hawk is equal to the parameter Hawk. Overrides
	//Animals equals() method.
	public boolean equals(Hawk inputAnimal){
		if(super.equals(inputAnimal)&&(inputAnimal.wingSpan == (this.wingSpan))){
			return true;
		}
		else
			return false;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
