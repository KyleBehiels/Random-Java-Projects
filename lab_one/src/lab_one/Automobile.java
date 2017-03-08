/* T00548219
 * Kyle Behiels
 */

package lab_one;

//Class designed as a parent. Will derive child classes under the category "Automobiles" 

public abstract class Automobile {
	
	/* Variables representing the following generic attributes, 
	 * common, in type but not value, with all automobiles; color and doors (amount of doors)
	 */
	protected String color;
	protected int doors;
	
	//Constructor for assigning values to color and doors variables
	
	public Automobile(String colorValue, int doorsValue){
		color = colorValue;
		doors = doorsValue;
	}
	
	//Method for accessing the "color" variable returns - String color
	
	protected String getColor(){
		return color;
	}
	
	//Method for changing the "color" variable returns - void
	
	protected void setColor(String colorValue){
		color = colorValue;
	}
	
	//Method for accessing the "doors" variable returns - int doors
	
	protected int getDoors(){
		return doors;
	}
	
	//Method for changing the "doors" variable returns - void
	
	protected void setDoors(int doorsValue){
		doors = doorsValue;
	}
	
	//Returns String representation of all the automobiles values. Includes labels and overrides java.object.toString()
	
	public String toString(){
		return "Doors = "+doors+", Color = "+color;
	}
}
