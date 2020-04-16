package linkedListBasics;
//A generic class for creating linkedlist nodes
public class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}