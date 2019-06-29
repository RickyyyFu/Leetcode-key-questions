package LC_285_Inorder_Successor_in_BST;

public class Solution_BST2 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val =val;
		}
	}
	
	TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null) return null;
		
		if(p.val >= root.val) {
			return inorderSuccessor(root.right, p);
		}
		else {
			TreeNode left = inorderSuccessor(root.left, p);
			if(left == null) {
				return root;
			}else {
				return left;
			}
		}
	}
}
