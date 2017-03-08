/**
 * Driver class for testing items of the thisBox class 
 * @author Kyle
 *
 */
public class boxArrayTester {

	public static void main(String[] args){
		//Create Box objects. 
		thisBox<Integer> hoursBox = new thisBox<Integer>(4);
		thisBox<String> nameBox = new thisBox<String>(4);
		
		//Add integers 6,7,8,9 to hoursBox
		for(int i = 6; i<10; i++){
			hoursBox.add(i);
		}
		
		//Add friend names to nameBox
		nameBox.add("Friend_One");
		nameBox.add("Friend_Two");
		nameBox.add("Friend_Three");
		nameBox.add("Friend_Four");
		
		//Run ten tests to prove (sudo)randomness
		for(int i = 1; i<=10; i++){
			System.out.println("Test #"+i);
			System.out.println("----------------------------------------------------------");
			System.out.println("|       You will study for "+hoursBox.drawItem()+" hours with "+nameBox.drawItem()+".     |");
			System.out.println("----------------------------------------------------------");
		}
		
	} 

}
