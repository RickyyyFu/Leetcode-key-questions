package LC_431_Encode_Nary_Tree_to_Binary_Tree;

import java.util.*;

class Solution { 
	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
		    children = _children;
		}
	}
	
	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode() {}
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	// Encodes an n-ary tree to a binary tree.
    TreeNode encode(Node root) {
        if(root == null) return null;
        
        TreeNode res = new TreeNode(root.val);
        if(!root.children.isEmpty()) {
        	res.left = encode(root.children.get(0));
        }
        TreeNode cur = res.left;
        for(int i = 1; i < root.children.size(); i++) {
        	cur.right = encode(root.children.get(i));
        	cur = cur.right;
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    Node decode(TreeNode root) {
        if(root == null) return null;
        
        Node res = new Node(root.val, new ArrayList<Node>());
        TreeNode cur = root.left;
        while(cur != null) {
        	res.children.add(decode(cur));
        	cur = cur.right;
        }
        return res;
    }
}
