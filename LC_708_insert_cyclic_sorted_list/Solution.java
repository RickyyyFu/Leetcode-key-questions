package LC_708_insert_cyclic_sorted_list;

public class Solution {
	
	class Node{
		int val;
		Node next;
		
		Node(int val){
			this.val = val;
		}
	}
	
	public Node insert(Node head, int insertVal) {
		Node target = new Node(insertVal);
		if(head == null) {
			target.next = target;
			return target;
		}
		
		Node node = head.next;
		while(node != head) {
			// case 1
			if(node.val < node.next.val) {
				if(node.val <= insertVal && node.next.val >= insertVal) {
					target.next = node.next;
					node.next = target;
					
					return head;
				}
			}
			// case 2
			else if(node.val > node.next.val) {
				if(node.val > insertVal || insertVal < node.next.val) {
					target.next = node.next;
					node.next = target;
					
					return head;
				}
			}
			// case 3
			else {
				if(node.val == insertVal) {
					target.next = node.next;
					node.next = target;
					
					return head;
				}
			}
		}
		// case 4
		target.next = node.next;
		node.next = target;
		
		return head;
		 
	}
}
