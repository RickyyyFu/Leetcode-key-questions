package LC_285_Inorder_Successor_in_BST;


public class Solution_recursive {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val =val;
		}
	}
	
	TreeNode pre, suc;
	TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(p == null) return null;
		recursive(root, p);
		return suc;
	}
	
	void recursive(TreeNode node, TreeNode p){
		if(node == null) return;
		
		recursive(node.left, p);
		if(pre.val == p.val) {
			suc = node;
		}
		pre = node;
		recursive(node.right, p);
	}
}
