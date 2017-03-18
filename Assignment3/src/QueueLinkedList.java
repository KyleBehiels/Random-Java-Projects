import java.util.Set;

public class QueueLinkedList<T> {
	
	//Objects enter the tail and exit the head
	Node head, tail;
	
	private int size = 0;
	
	//Defining node inner class.
	class Node{
		T data;				//Data stored in current node
		Node next, previous;				//Node objects that store both the previous and next nodes in the queue
		public Node(T data){			//Constructor that adds the data
			this.data = data; 
		}
	}
	
	//Equivelant to push in a stack - adds an element to the tail
	public void offer(T data){
		size ++;							//Increase the size every offer() call
		
		//First offer
		if(tail == null && head == null){
			tail = new Node(data);					//If this is the first commit then set both head and tail to a new Node
			head = tail;
			return;										//Offer complete
		}
		else if(head == tail){				//If this is the second offer...
			Node tempNode = new Node(data);					//create a temporary node
			tempNode.previous = tail;									//link the new node with the tail
			tempNode.previous.next = tempNode;				//link the tail with the new node
			tail = tempNode;												//set tail to the new node
			head.next = tail;										//Store the new tail in head.next 
		}
		else{									//If this is not the first or second offer
			Node tempNode = new Node(data);				//Create a new node 
			tempNode.previous = tail;							//set tempNode.previous to point at the tail
			tempNode.previous.next = tempNode;		//Link the tail to the new node
			tail = tempNode;							//Set the tail to the new node
		}
	}
	
	//Check if the Stack is empty
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
	
	//Equivelent to pop in a stack - removes an element from head
	public T poll(){
		T returnable;					//Store the data that is to returned
		if(head!=null){				//If the queue is not empty
			size--;						//Size reduced by one 
			returnable = head.data;		//Set the returnable variable to the data contained in the return node
			if(head == tail){					//if the array is only one element long, set everything to null
				head = null;
				tail = null;
			}
			else{									//Else set head to point at the next element in the Queue
				head = head.next;
			}
		}									//If the queue is empty return null Otherwise...
		else{
			returnable = null;
		}
		
		return returnable;			//... return the proper value;
	}
	
	//Getter for size property
	public int size(){
		return size;
	}

}
