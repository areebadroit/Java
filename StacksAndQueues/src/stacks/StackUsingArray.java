package stacks;


class Stack_Arr {
	
	private int data[];
	private int top; // is the index of topmost element of stack
	
	public Stack_Arr() {
		data = new int[10];
		top = -1;
	}
	
	public Stack_Arr(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public  boolean isEmpty(){
//		if(top == -1){
//			return true;
//		}else{
//			return false;
//		}
		return (top == -1);
	}
	
	public int size(){
		return top + 1;	
		}
	
	public int top() throws StackEmptyException{
		if(size() == 0){
			//StackEmptyException
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top];
	}
	
	public void push(int elem) throws StackFullException{
		if(size() == data.length){
			// Stack Full
			StackFullException e = new StackFullException();
			throw e;			
		}
		top++;
		data[top] = elem;
	}

	public int pop() throws StackEmptyException{
		if(size() == 0){
			//StackEmptyException
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		int temp = data[top];
		top--;
		return temp;
		
	}
}
public class StackUsingArray {
	//Basic Runner class to check stack functionalities is working properly or not.
	//We have not taken the size of array as input from user instead created an array of size 5.
	//You can modify this function and size of array accd to your needs or take input from user
	public static void main(String[] args) throws StackFullException {		
		Stack_Arr stack = new Stack_Arr(5);
		for(int i = 1; i <= 5; i++){
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			try {
				System.out.println(stack.pop());
			} catch (StackEmptyException e) {
				// Never reach here
			}
		}

	}

}
