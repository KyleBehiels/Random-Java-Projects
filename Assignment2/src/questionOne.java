
import java.util.Arrays;

public class questionOne<T>{

	public final static int DEFAULT_CAPACITY = 10;		//Size of array for use in default constructor
	public int size;		//Element that will contain the size of the array after either constructor
	public T[] arrayStack;		//The actual array for storing values
											
	public int top = -1;			//The element representing the top of the array. Starts at -1 so that when an object is pushed and the top is increased by one,
											// the top will actually point at 0 which is the true top of the stack.
											 
		

	//Constructor that allows the user to define their own starting size
	public questionOne(int arraySize){
		size = arraySize;
		arrayStack =  (T[])(new Object[size]);
	}
	
	//Default constructor that automatically sets the default size to 10
	public questionOne(){
		size = DEFAULT_CAPACITY;
		arrayStack =  (T[])(new Object[size]);
	}
	
	/*
	 * Typical push method for adding an element to the array
	 * Expands the array when full
	 */
	private void push(T pushable){
		if(arrayStack[arrayStack.length-1]==null){
			expandArray();
		}
		arrayStack[top+1] = pushable;
		top++;
	}
	
	//Copy the array into a clone of itself with twice the capacity
	private void expandArray(){
		arrayStack = Arrays.copyOf(arrayStack, arrayStack.length*2);
	}
	
	//Typical pop method, returns the top element in the array and deletes it
	private T pop(){
		T returnable = arrayStack[top];
		arrayStack[top] = null;
		top--;
		return returnable;
	}
	
	//Returns the top element in the array without deleting it
	private T peek(){
		return arrayStack[top];
	}
	
	//Returns true if the array is empty (element in index [0] is null) and false if it is not (element at index [0] is not null)
	private boolean isEmpty(){
		if(arrayStack[0]==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Returns an int corresponding to the amount of objects stored in the array but not the size of the array itself
	public int size(){
		return top+1;
	}
	
}
