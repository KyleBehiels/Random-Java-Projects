/* T00548219
 * Kyle Behiels
 */

//Standard class derived from the parent class "Animal"
public class Elephant extends Animal{

	int weight;
	//Constructor, adding the variable "weight"
	public Elephant(String soundIn, String movementIn, String nameIn, int weightIn) {
		super(soundIn, movementIn, nameIn);
		weight = weightIn;
	}
	//"setter" method for weight
	protected void setWeight(int weightIn){
		weight = weightIn;
	}
	//"getter" method for weight
	protected int getWeight(){
		return weight;
	}
	//Returns a String representation of this particular instance of Elephant. Overrides Animals
	//toString() method.
	public String toString(){
		return super.toString()+" Weight: "+weight+".";
	}
	//Method for checking if this instance of Elephant is equal to the parameter Elephant. Overrides
	//Animals equals() method.
	public boolean equals(Elephant inputAnimal){
		if(super.equals(inputAnimal)&&(inputAnimal.weight == (this.weight))){
			return true;
		}
		else
			return false;
	}
}
