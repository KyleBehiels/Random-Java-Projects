/* T00548219
 * Kyle Behiels
 */

package lab_one;

//Class inheriting data and methods from Automobile() 

public class Car extends Automobile{
	protected int trunkCapacity;
	
	/* Constructor method calling on the values color and doors 
	 * from Automobile and defining trunk Capacity as a new variable
	 */
	public Car(String colorValue, int doorsValue, int trunkCapacityValue) {
		super(colorValue, doorsValue);
		trunkCapacity = trunkCapacityValue;
	}
	
	//Returns String representation of all the cars values. Includes labels and overrides java.object.toString()
	
	public String toString(){
		return "Color = "+color+", Doors = "+doors+", Trunk Capacity = "+trunkCapacity+" Litres";
	}
	
	//Returns the integer value associated with the cars trunk capacity. Unit of measure = litres
	
	protected int getTrunkCapacity(){
		return trunkCapacity;
	}
	
	//Sets the value of trunk capacity to the parameter trunkCapacityValue when called
	
	protected void setTrunkCapacity(int trunkCapacityValue){
		trunkCapacity = trunkCapacityValue;
	}
}
