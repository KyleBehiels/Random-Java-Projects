

public class StackLinkedList<T> {
	
	Node topNode;
	Node node;
	int size = 0;
	
	public StackLinkedList(){
		
		node = new Node(null);
		topNode = new Node(null);
		
	}
	
	//Push method for the Stack
	public void push(T data){
		size++;
		if(topNode == null){
			topNode = new Node(data);
		}
		else{
			Node tempNode = new Node(data);
			tempNode.next = topNode;
			topNode = tempNode;
		}
	}
	//Returns a boolean indicating whether or not the stack is empty
	public boolean isEmpty(){
		if(topNode == null){
			return true;
		}
		return false;
	}
	
	//Pop method for the stack (return and remove top node)
	public T pop(){
		T returnable;
		//If the stack contains data
		if(topNode.data!=null){
			returnable = topNode.data;
			topNode = topNode.next;
			size--;
		}
		else{
			return null;
		}
		
		return returnable;
	}
	
	//Return the data stored in the top node
	public T peek(){
		return topNode.data;
		
	}
	//Method for returning the size of the stack
	public int size(){
		return size;
	}
	
	//Definition of one node in link
	class Node{
		T data;
		Node next;
		public Node(T data){
			this.data = data; 
		}
	}
	
	
}
