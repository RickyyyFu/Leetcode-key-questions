package LC_285_Inorder_Successor_in_BST;

public class Solution_BST1 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val =val;
		}
	}
	
	TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		
		while(root != null) {
			if(p.val < root.val) {
				res = root;
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
		return res;
	}
}
