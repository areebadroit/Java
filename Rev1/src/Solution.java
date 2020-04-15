

/*
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
* */

public class Solution {
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp=head;
        if(temp==null)
            return temp;
        while(temp.next!=null){
            if(temp.data==temp.next.data){
            	LinkedListNode<Integer> p=temp.next.next;
            	temp.next=p;
            }else{
            temp=temp.next;
            }
        }
        return head;
//         LinkedListNode<Integer> curr = head; 
  
       
//         while (curr != null) { 
//              LinkedListNode<Integer> temp = curr; 
            
//             while(temp!=null && temp.data==curr.data) { 
//                 temp = temp.next; 
//             } 
            
//             curr.next = temp; 
//             curr = curr.next; 
//         } 
//         return head;
    }
}