/* T00548219
 * Kyle Behiels
 */

package lab_one;

//Simple driver class for testing truck and car classes.

public class Test_Driver {
	
	public static void main(String[] args){
		
		//Construct a red truck with four doors and a six foot bed.
		
		Truck sexyTruck = new Truck("Red", 4, 6);
		
		//Construct a grey car with four doors and a 20 litre trunk space.
		
		Car boringCar = new Car("Grey", 4, 20);
		
		//BEGIN - testing Car class
		
		System.out.println("Begin Car Tests ====================================");
		
		//GETTERS
		
		System.out.println("GETTERS===================================");
		System.out.println();
		System.out.println("Testing \"getColor()\" method");
		System.out.println("The Cars Color is "+boringCar.getColor()+".");
		System.out.println();
		System.out.println("Testing \"getDoors()\" method");
		System.out.println("The Car Has "+boringCar.getDoors()+" Doors.");
		System.out.println();
		System.out.println("Testing \"getTrunkCapacity()\" method");
		System.out.println("The Car Has a "+boringCar.getTrunkCapacity()+" Litre trunk capacity.");
		System.out.println();
		
		//SETTERS
		
		System.out.println("SETTERS===================================");
		System.out.println();
		System.out.println("Testing \"setColor()\" method, setting color to \"Blue\"");
		boringCar.setColor("Blue");
		System.out.println("The Cars Color is "+boringCar.getColor()+".");
		System.out.println();
		System.out.println("Testing \"setDoors()\" method, setting doors to 2.");
		boringCar.setDoors(2);
		System.out.println("The Car Has "+boringCar.getDoors()+" Doors.");
		System.out.println();
		System.out.println("Testing \"setTrunkCapacity()\" method, setting trunk capacity to 40.");
		boringCar.setTrunkCapacity(40);
		System.out.println("The Car Has a "+boringCar.getTrunkCapacity()+" Litre trunk capacity.");
		System.out.println();
		
		//toString() method
		
		System.out.println("Testing the \"toString\" method.");
		System.out.println(boringCar.toString());
		System.out.println();
		System.out.println("End Car Tests ====================================");
		System.out.println();
		//END - testing Car class
		
		//BEGIN - testing Truck class
		
		System.out.println("Begin Truck Tests ====================================");
		System.out.println();
		//GETTERS
		
		System.out.println("GETTERS===================================");
		System.out.println();
		System.out.println("Testing \"getColor()\" method");
		System.out.println("The Trucks Color is "+sexyTruck.getColor()+".");
		System.out.println();
		System.out.println("Testing \"getDoors()\" method");
		System.out.println("The Truck Has "+sexyTruck.getDoors()+" Doors.");
		System.out.println();
		System.out.println("Testing \"getBoxLength()\" method");
		System.out.println("The Truck Has a "+sexyTruck.getBoxLength()+"\' box length.");
		System.out.println();
		
		//SETTERS
				
		System.out.println("SETTERS===================================");
		System.out.println();
		System.out.println("Testing \"setColor()\" method, setting color to \"Blue\"");
		sexyTruck.setColor("Blue");
		System.out.println("The Trucks Color is "+sexyTruck.getColor()+".");
		System.out.println();
		System.out.println("Testing \"setDoors()\" method, setting doors to 2.");
		sexyTruck.setDoors(2);
		System.out.println("The Truck Has "+sexyTruck.getDoors()+" Doors.");
		System.out.println();
		System.out.println("Testing \"setBoxLength()\" method, setting box length to 8 feet.");
		sexyTruck.setBoxLength(8);
		System.out.println("The Truck Has a "+sexyTruck.getBoxLength()+"\' box length.");
		System.out.println();
		
		//toString() method
		
		System.out.println("Testing the \"toString\" method.");
		System.out.println(sexyTruck.toString());
		System.out.println();
		System.out.println("End Car Tests ====================================");
				
		//END - testing Car class
	}

}
