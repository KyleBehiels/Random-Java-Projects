

public class mainTester {
	
	static String seperator = "======================================";
	
	public static void main(String[] args){
		
		StackLinkedList linkedStack = new StackLinkedList();
		
		//Testing Linked List stack
		
		System.out.println("Testing Stack - Linked List implementation");
		System.out.println(seperator);
		System.out.println("Pushing Strings \"testOne\", \"testTwo\", \"testThree\", \"testFour\"");
		linkedStack.push("testOne");
		linkedStack.push("testTwo");
		linkedStack.push("testThree");
		linkedStack.push("testFour");
		System.out.println(seperator);
		System.out.println("Peeking");
		System.out.println(linkedStack.peek());
		System.out.println(seperator);
		System.out.println("Size = "+linkedStack.size());
		System.out.println(seperator);
		System.out.println("Popping twice");
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.pop());
		System.out.println(seperator);
		System.out.println("Using for loop and size getter to iterize the\nlast two elements and pop them");
		System.out.println(linkedStack.size());
		
		int sSize = linkedStack.size();
		for(int i = 0; i<sSize;i++){
			System.out.println(linkedStack.pop());
		}
		System.out.println(seperator);
		System.out.println("Pushing testFive peeking, then popping for good measure.");
		linkedStack.push("testFive");
		System.out.println(linkedStack.peek());
		System.out.println(linkedStack.pop());
		System.out.println(seperator);
		
		//Testing Linked List Queue
		QueueLinkedList queue = new QueueLinkedList();
		System.out.println("Testing Queue - Linked List implementation");
		System.out.println(seperator);
		System.out.println("Offering Strings testOne, testTwo, testThree, testFour, testFive");
		queue.offer("testOne");
		queue.offer("testTwo");
		queue.offer("testThree");
		queue.offer("testFour");
		queue.offer("testFive");
		System.out.println(seperator);
		System.out.println("Polling twice");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(seperator);
		System.out.println("Offering testSix");
		queue.offer("testSix");
		System.out.println(seperator);
		System.out.println("Iterizing and polling with the help of size()");
		int qSize = queue.size();
		for(int i = 0; i<  qSize;i++){
			System.out.println(queue.poll());
		}
		//Testing ArrayList implementation of Stack
		System.out.println(seperator);
		System.out.println("Testing ArrayList implementation of a stack");
		System.out.println(seperator);
		stackArrayList<String> myStack = new stackArrayList<String>();
		System.out.println("Pushing string values: \"testOne\",  \"testTwo\", \"testThree\", \"testFour\"");
		myStack.push("testOne");
		myStack.push("testTwo");
		myStack.push("testThree");
		myStack.push("testFour");
		System.out.println(seperator);
		System.out.print("Peeking the top value: ");
		System.out.println(myStack.peek());
		System.out.println(seperator);
		System.out.println("Popping twice: ");
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(seperator);
		System.out.println("Size: "+myStack.size());
		System.out.println(seperator);
		System.out.println("Testing the size() function by using it to iterize the stack.");
		int stackSize = myStack.size();
		for(int i = 0; i< stackSize; i++){
			System.out.println(myStack.pop());
		}
		System.out.println(seperator);
		System.out.println("Is empty: "+myStack.isEmpty());
		System.out.println(seperator);
		
	}
}
