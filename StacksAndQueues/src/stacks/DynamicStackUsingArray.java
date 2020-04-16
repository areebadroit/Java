package stacks;


class DynamicStack {
	
	private int data[];
	private int top; // is the index of topmost element of stack
	
	public DynamicStack() {
		data = new int[10];
		top = -1;
	}
	
	public DynamicStack(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public  boolean isEmpty(){
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
//			// Stack Full
//			StackFullException e = new StackFullException();
//			throw e;
			doubleCapacity();
			
		}
		top++;
		data[top] = elem;
	}

	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2 * temp.length];
		for(int i = 0; i <= top; i++){
			data[i] = temp[i];
		}
		
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

public class DynamicStackUsingArray {
	public static void main(String[] args){
		//This is a stack of dynamic capacity
		/*Initially a stack is created using an array of 3, but as soon as the stack becomes full a new stack using array 
		of double size is automatically created, hence this will never throw StackFullException*/
		DynamicStack stack = new DynamicStack(3);
		for(int i = 1; i <= 5; i++){
			try {
				stack.push(i);
			} catch (StackFullException e) {
				// Never reach here
			}
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
