package LC_250_Count_Univalue_Subtrees;

public class Solution {
		
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val =val;
		}
	}
	
	int count = 0;
	
	public boolean isUni(TreeNode node) {
		boolean is_uni = true;
		
		if(node.left == null && node.right == null) return true;
		
		if(node.left != null) {
			is_uni = is_uni && isUni(node.left) && node.val == node.left.val;				
		}
		if(node.right != null) {
			is_uni = is_uni && isUni(node.right) && node.val == node.right.val;				
		}
		
		if(is_uni == true) {
			count++;
		}
		
		return is_uni;
	}
	
	public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUni(root);
        return count;
    }
}
