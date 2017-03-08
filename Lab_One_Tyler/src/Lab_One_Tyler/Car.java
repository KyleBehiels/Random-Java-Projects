// T00052042

package Lab_One_Tyler;

//Class inheritance from Parent Automobile to Child Car
public class Car extends Automobile {

	protected int trunkCapacity;

	// Constructor assigns values to color, doors and trunkCapacity
	public Car(String colorValue, int doorsValue, int trunkCapacityValue) {

		super(colorValue, doorsValue);
		trunkCapacity = trunkCapacityValue;
	}

	// toString for Car class. Returns color, doors and trunk capacity
	public String toString() {
		return "Color = " + color + ", Doors = " + doors + ", Trunk Capacity = " + trunkCapacity + "Litres";
	}

	// getTruckCapacity method. Returns an int value.
	protected int getTrunkCapacity() {
		return trunkCapacity;
	}

	// Sets trunkCapacity to trunkCapacityValue
	protected void setTrunkCapacity(int trunkCapacityValue) {
		trunkCapacity = trunkCapacityValue;
	}
}
