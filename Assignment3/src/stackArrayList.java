//Importing supporting classes
import java.util.ArrayList;
import java.util.EmptyStackException;

//stackArrayList uses an array list to store an object T in a structure similar to a Stack
public class stackArrayList<T>{
	ArrayList<T> dataList;			//List that the objects are stored in
	int top = 0;				//Points to the top of the stack (dataList[top] is null because it is one above the top element)
	
	//Constructor that initializes the ArrayList
	public stackArrayList() {
		dataList = new ArrayList<T>();
	}
	
	//Push uses the "add" method to add an element to dataList at the top. Top is then increased by one.
	public void push(T pushable){
		dataList.add(pushable);
		top++;
	}
	
	//Remove an element from the dataList at position "top" and return it
	public T pop(){
		T returnable = dataList.get(top-1);		//store variable to return
		dataList.remove(top-1);		//remove the val from the list
		top--;		//move top down one
		return returnable;
	}
	
	//Returns the value that is currently at position "top" without removing it
	public T peek() {
			return dataList.get(top-1);	//return dataList[top]
	}
	
	//Method that checks if the dataList is empty and returns a boolean
	public boolean isEmpty(){
		if(top == 0){
			return true;
		}
		else{
			return false;
		}
	}
	//Method that returns an int corresponding to that amount of elements stored in dataList
	public int size(){
		return top;
	}
}