import java.util.Arrays;

import javax.xml.stream.events.EndDocument;

public class myDeque<T> {
	
	public static final int default_size = 10;
	public int end = 0;
	public T[] dequeArray;
	
	public myDeque(){
		dequeArray = (T[])(new Object[default_size]);
	}
	
	public myDeque(int chosenSize){
		dequeArray = (T[])(new Object[chosenSize]);
	}
	
	@Override
	public String toString(){
		String returnable = "";
		for(int i = 0; i<end; i++){
			returnable = returnable+dequeArray[i]+", ";
		}
		return returnable;
	}
	
	public void expandArray(){
		dequeArray = Arrays.copyOf(dequeArray, dequeArray.length*2);
	}
	
	public void pushEnd(T addable){
		if(end>=(dequeArray.length)){
			expandArray();
		}
		dequeArray[end] = addable;
		end++;
	}
	
	public void shiftElementsRight(){
		for(int i = dequeArray.length-1; i>0; i--){
			dequeArray[i] = dequeArray[i-1];
		}
	}
	
	public void shiftElementsLeft(){
		for(int i = 0; i<dequeArray.length-1; i++){
			dequeArray[i] = dequeArray[i+1];
		}
	}
	
	public void pushStart(T addable){
		if((end+1)>dequeArray.length){
			expandArray();
		}
		shiftElementsRight();
		end++;
		dequeArray[0] = addable;
	}
	
	public T popStart(){
		T returnable = dequeArray[0];
		shiftElementsLeft();
		end--;
		return returnable;
	}
	
	public T popEnd(){
		if(end>0){
			T returnable = dequeArray[end-1];
			dequeArray[end-1] = null;
			end--;
			return returnable;
		}
		else{
			return null;
		}
	}
	
	public T peekStart(){
		return dequeArray[0];
	}
	
	public T peekEnd(){
		if(end>0){
			return dequeArray[end-1];
		}
		else{
			return null;
		}
	}
	
	public int size(){
		return end;
	}
	
	
}
