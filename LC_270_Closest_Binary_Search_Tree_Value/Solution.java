package LC_270_Closest_Binary_Search_Tree_Value;

public class Solution {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}
	
	int closestValue(TreeNode root, double target) {
        if (root.val == target) return root.val;
        if (root.val < target) {
            if (root.right == null) return root.val;
            int right = closestValue(root.right, target);
            if (Math.abs(root.val-target) <= Math.abs(right-target)) return root.val;
            return right;
        } else {
            if (root.left == null) return root.val;
            int left = closestValue(root.left, target);
            if (Math.abs(root.val-target) <= Math.abs(left-target)) return root.val;
            return left;
        }
	}
}
