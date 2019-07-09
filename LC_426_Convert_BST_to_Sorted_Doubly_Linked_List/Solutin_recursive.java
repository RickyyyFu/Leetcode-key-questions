package LC_426_Convert_BST_to_Sorted_Doubly_Linked_List;

public class Solutin_recursive {
	
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
	
	Node first = null;
	Node last = null;
	
	public Node treeToDoublyList(Node root) {
		if(root == null) return null;
		
		recursive(root);
		last.right = first;
		first.left = last;
		
		return first;
	}
	
	void recursive(Node node) {
		if(node == null) return;
		
		recursive(node.left);
		if(first == null) first = node;
		if(last != null) {
			last.right = node;
			node.left = last;
		}
		last = node;
		recursive(node.right);
	}
}
