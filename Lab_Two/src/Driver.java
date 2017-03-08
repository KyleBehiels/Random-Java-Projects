/*
 * Kyle Behiels
 * T00548219
 */


public class Driver {

	public static void main(String[] args){
		//Instantiation of objects 
		String seperator = "===========================================";
		Elephant firstElephant = new Elephant("trumpet", "walk");
		Elephant crippledElephant = new Elephant("trumpet", "limp");
		Hawk firstHawk = new Hawk("shriek", "fly");
		Hawk twinHawk = new Hawk("shriek", "fly");
		Snake firstSnake = new Snake("hiss", "slither");

		// Begin testing with print statements
		
		//Equals Method Testing
		//-------------------------------------------------------
		System.out.println(seperator);
		System.out.println("Testing \"equals()\" method");
		System.out.println("If firstElephant equals crippledElephant print same. Else print different.");
		if(firstElephant.equals(crippledElephant)){
			System.out.println("Same");
		}
		else
			System.out.println("Different");
		System.out.println(seperator);
		System.out.println("If firstHawk equals twinHawk print same. Else print differrent.");
		if(firstHawk.equals(twinHawk)){
			System.out.println("Same");
		}
		else
			System.out.println("Different");
		System.out.println(seperator);
		
		//Testing all toString() methods
		//-------------------------------------------------------
		
		System.out.println("First Elephant \n ---------------------------------------");
		System.out.println(firstElephant.toString());
		System.out.println(seperator);
		System.out.println("Crippled Elephant \n ---------------------------------------");
		System.out.println(crippledElephant.toString());
		System.out.println(seperator);
		System.out.println("First Hawk \n ---------------------------------------");
		System.out.println(firstHawk.toString());
		System.out.println(seperator);
		System.out.println("Twin Hawk \n ---------------------------------------");
		System.out.println(twinHawk.toString());
		System.out.println(seperator);
		System.out.println("First Snake \n ---------------------------------------");
		System.out.println(firstSnake.toString());
		System.out.println(seperator);
		
		//Testing all sound() methods
		//-------------------------------------------------------
		
		System.out.println("First Elephant Sound \n ---------------------------------------");
		System.out.println(firstElephant.sound());
		System.out.println(seperator);
		System.out.println("Crippled Elephant Sound \n ---------------------------------------");
		System.out.println(crippledElephant.sound());
		System.out.println(seperator);
		System.out.println("First Hawk Sound \n ---------------------------------------");
		System.out.println(firstHawk.sound());
		System.out.println(seperator);
		System.out.println("Twin Hawk Sound \n ---------------------------------------");
		System.out.println(twinHawk.sound());
		System.out.println(seperator);
		System.out.println("First Snake Sound \n ---------------------------------------");
		System.out.println(firstSnake.sound());
		System.out.println(seperator);
		
		//Testing all movement() methods
		//-------------------------------------------------------
		
		System.out.println("First Elephant Movement \n ---------------------------------------");
		System.out.println(firstElephant.movement());
		System.out.println(seperator);
		System.out.println("Crippled Elephant Movement \n ---------------------------------------");
		System.out.println(crippledElephant.movement());
		System.out.println(seperator);
		System.out.println("First Hawk Movement \n ---------------------------------------");
		System.out.println(firstHawk.movement());
		System.out.println(seperator);
		System.out.println("Twin Hawk Movement \n ---------------------------------------");
		System.out.println(twinHawk.movement());
		System.out.println(seperator);
		System.out.println("First Snake Movement \n ---------------------------------------");
		System.out.println(firstSnake.movement());
		System.out.println(seperator);
	}
	
}
