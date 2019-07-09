package LC_426_Convert_BST_to_Sorted_Doubly_Linked_List;

import java.util.*;

public class Solution_iterate {
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	
	public Node treeToDoublyList(Node root) {
		if(root == null) return null;
		Node first = null;
		Node last = null;
		
		Stack<Node> stack = new Stack<>();
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			if(first == null) first = root;
			if(last != null) {
				last.right = root;
				root.left = last;
			}
			last = root;
			
			root = root.right;
		}
		
		last.right = first;
		first.left = last;
		
		return first;
	}
}
