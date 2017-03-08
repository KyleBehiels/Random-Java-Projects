
public class dropOutStack<T> {
	
	public final int maxSize;
	public int currentSize;
	
	Exception emptyStackException = new Exception("The stack is empty!");
	Exception stackSizeException = new Exception("The stack size must be greater than 0.");
	
	public dropOutStack(int stackSize) throws Exception{
		first = new Node(null);
		last = new Node(null);
		if(stackSize>=1){
			maxSize = stackSize;
		}
		else{
			throw stackSizeException;
		}
	}
	
	public int size(){
		return maxSize;
	}

	private class Node{
		private T data;
		private Node next;
		private Node previous;
		public Node(T data){
			this.data = data; 
		}
	}
	
	private Node first;
	private Node last;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public T peek(){
		if(last!=null){
			return last.data;
		}
		else{
			return null;
		}
	}
	public void push(T newData){
		Node node = new Node(newData);
		if(first.data != null){		//If the stack already contains elements...
			if(currentSize<=maxSize){		//If the stack is not yet full...
				
				currentSize++;		// Add one to the size of the stack
			
				//Migrate data from the head of the stack to a new, arbitrary node
				node.data = first.data;
				node.next = first.next;
				node.previous = first;
				
				//Assign new data to the new head of the stack and link the newly created node
				first.data = newData;
				first.next = node;
			}
			else{			// If the stack is full...
				/*
				 * Overwrite the last element using the element contained in the last.previous
				 * variable, thus "dropping out" the bottom of the stack.
				 */
				last = last.previous;
			}
		}
		else{		// If this is the first push command
			first.data = newData;
			last.data = newData;
			last.previous = first;
		}
		
	}
	
	public T pop() throws Exception{
		if(first != null){
			T returnData = first.data;
			first = first.next;
			first.previous = null;
			currentSize--;
			return returnData;
		}
		else{
			throw emptyStackException;
		}
	}
	
	
}
