
public class QueueLinkedList<T> {
	
	//Objects enter the tail and exit the head
	Node head, tail;
	
	private int size = 0;
	
	//Defining node inner class
	class Node{
		T data;
		Node next, previous;
		public Node(T data){
			this.data = data; 
		}
	}
	
	//Equivelant to push in a stack - adds an element to the tail
	public void offer(T data){
		size ++;
		
		//First offer
		if(tail == null && head == null){
			tail = new Node(data);
			head = tail;
			return;
		}
		else if(head == tail){
			Node tempNode = new Node(data);
			tempNode.previous = tail;
			tempNode.previous.next = tempNode;
			tail = tempNode;
			head.next = tail;
		}
		else{
			Node tempNode = new Node(data);
			tempNode.previous = tail;
			tempNode.previous.next = tempNode;
			tail = tempNode;
		}
	}
	
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
	
	//Equivelent to pop in a stack - removes an element from a head
	public T poll(){
		T returnable;
		if(head!=null){
			size--;
			returnable = head.data;
			if(head == tail){
				head = null;
				tail = null;
			}
			else{
				head = head.next;
			}
		}
		else{
			returnable = null;
		}
		
		return returnable;
	}
	
	//Getter for size property
	public int size(){
		return size;
	}

}
