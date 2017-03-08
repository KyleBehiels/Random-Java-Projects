/**
 * @author Kyle
 * Class that handles the various methods for dealing with the Array
 */

import java.lang.*;

public class thisBox<T> implements Box {
	
	private static final int defaultSize = 10;
	T[] dataArray, tempArray;
	private int index = 0;

	//Constructor defines size of dataArray
	public thisBox(){
		this(defaultSize);
	}
	
	public thisBox(int arraySize){
		dataArray = (T[]) new Object[defaultSize];
		tempArray = (T[]) new Object[defaultSize];
	}
	
	// Add an object to the array
	public void add(Object someObject) {
		if(!(dataArray[dataArray.length-1]==(null))){
			expandArray();
			dataArray[index] = (T) someObject;
			index++;	
		}
		else{
			dataArray[index] = (T) someObject;
			index++;
		}
	}
	
	//Expand the array to double it's previous size
	public void expandArray(){
		for(int i = 0; i<dataArray.length;i++){
			tempArray[i] = dataArray[i];
		}
		dataArray = (T[]) new Object[dataArray.length*2];
		for(int i = 0; i<tempArray.length;i++){
			dataArray[i] = tempArray[i];
		}
		tempArray = (T[]) new Object[tempArray.length*2];
	}
	
	//returns true if dataArray is empty. Else returns false.
	public boolean isEmpty() {
		for(int i = 0; i<dataArray.length; i++){
			if(!(dataArray[i]==null)){
				return false;
			}
		}
		return true;
	}
	
	//Returns a random element from the array dataArray
	public Object drawItem() {
		int randomIndex = (int)Math.round(Math.random()*(index-1));
		return dataArray[randomIndex];
	}
}
