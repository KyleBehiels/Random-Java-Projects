/* T00548219
 * Kyle Behiels
 */

package lab_one;

//Class inheriting data and methods from Automobile()

public class Truck extends Automobile{
	
	protected int boxLength;
	
	/* Constructor method calling on the values color and doors 
	 * from Automobile and defining box length as a new variable
	 */
	public Truck(String colorValue, int doorsValue, int boxLengthValue) {
		super(colorValue, doorsValue);
		boxLength = boxLengthValue;
	}
	
	//Returns String representation of all the trucks values. Includes labels and overrides java.object.toString()
	
	public String toString(){
		return "Color = "+color+", Doors = "+doors+", Box Length = "+boxLength+"\'";
	}
	
	//Returns the integer value associated with the trucks box length. Unit of measure = feet
	
	protected int getBoxLength(){
		return boxLength;
	}
	
	//Sets the value of box length to the parameter boxLengthValue when called
	
	protected void setBoxLength(int boxLengthValue){
		boxLength = boxLengthValue;
	}
	
}
