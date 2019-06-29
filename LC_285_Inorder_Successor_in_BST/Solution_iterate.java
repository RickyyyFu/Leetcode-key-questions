package LC_285_Inorder_Successor_in_BST;

import java.util.Stack;

public class Solution_iterate {
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val =val;
		}
	}
	
	TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		boolean findP = false;
		
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			if(findP == true) return node;
			if(p.val == node.val) {
				findP = true;
			}
			node = node.right;
		}
		
		return null;
	}
}
