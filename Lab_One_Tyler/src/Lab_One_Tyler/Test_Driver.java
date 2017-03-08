
//T00052042

package Lab_One_Tyler;
//Driver for testing truck and car classes.

public class Test_Driver {
	public static void main(String[] args) {

		// Creates a green truck with four doors and a six foot bed.
		Truck newTruck = new Truck("Green", 4, 6);
		// Creates a grey car with four doors and a 20 litre trunk space.
		Car newCar = new Car("Grey", 4, 20);

		System.out.println("Begin Car Test");

		// Get methods
		System.out.println("Getters");

		System.out.println("Testing \"getColor()\" method");
		System.out.println("The Cars Color is " + newCar.getColor() + ".");
		System.out.println();

		System.out.println("Testing \"getDoors()\" method");
		System.out.println("The Car Has " + newCar.getDoors() + " Doors.");
		System.out.println();

		System.out.println("Testing \"getTrunkCapacity()\" method");
		System.out.println("The Car Has a " + newCar.getTrunkCapacity() + " Litre trunk capacity.");

		// Set methods
		System.out.println();
		System.out.println("Setters");

		System.out.println("Testing \"setColor()\" method, setting color to \"Blue\"");
		newCar.setColor("Blue");
		System.out.println("The Cars Color is " + newCar.getColor() + ".");
		System.out.println();

		System.out.println("Testing \"setDoors()\" method, setting doors to 2.");
		newCar.setDoors(2);
		System.out.println("The Car Has " + newCar.getDoors() + " Doors.");
		System.out.println();

		System.out.println("Testing \"setTrunkCapacity()\" method, setting trunk capacity to 40.");
		newCar.setTrunkCapacity(40);
		System.out.println("The Car Has a " + newCar.getTrunkCapacity() + " Litre trunk capacity.");
		System.out.println();

		// toString() method
		System.out.println(newCar.toString());
		System.out.println("End Car Test");

		System.out.println();
		System.out.println("Begin Truck Test");

		// Get methods
		System.out.println("Getters");
		System.out.println("Testing \"getColor()\" method");
		System.out.println("The Trucks Color is " + newTruck.getColor() + ".");
		System.out.println();
		System.out.println("Testing \"getDoors()\" method");
		System.out.println("The Truck Has " + newTruck.getDoors() + " Doors.");
		System.out.println();

		System.out.println("Testing \"getBoxLength()\" method");
		System.out.println("The Truck Has a " + newTruck.getBoxLength() + "\' box length.");
		System.out.println();

		// Set methods
		System.out.println("Setters");

		System.out.println("Testing \"setColor()\" method, setting color to \"Blue\"");
		newTruck.setColor("Blue");
		System.out.println("The Trucks Color is " + newTruck.getColor() + ".");
		System.out.println();

		System.out.println("Testing \"setDoors()\" method, setting doors to 2.");
		newTruck.setDoors(2);
		System.out.println("The Truck Has " + newTruck.getDoors() + " Doors.");
		System.out.println();

		System.out.println("Testing \"setBoxLength()\" method, setting box length to 8 feet.");
		newTruck.setBoxLength(8);
		System.out.println("The Truck Has a " + newTruck.getBoxLength() + "\' box length.");
		System.out.println();

		// toString() method
		System.out.println("Testing the \"toString\" method.");
		System.out.println(newTruck.toString());
		System.out.println("End Car Test");
	}
}
