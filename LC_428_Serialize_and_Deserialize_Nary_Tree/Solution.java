package LC_428_Serialize_and_Deserialize_Nary_Tree;

import java.util.*;

public class Solution {
	public static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
		    children = _children;
		}
	}
	// Encodes a tree to a single string.
    public static String serialize(Node root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(String.valueOf(root.val)).append(" ").append("#").append(" ");
        
        while(!queue.isEmpty()) {
        	// 区分出每个节点的子节点集合
            Node node = queue.poll();
            if(!node.children.isEmpty()) {
            	for(Node child : node.children) {
                	queue.offer(child);
                	sb.append(String.valueOf(child.val) + " ");
                }
            }
        	sb.append("# "); // 一个集合结束，加#间隔
        }
        return sb.toString();
        
    }
 
    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        
        String[] str = data.split(" ");
        int length = str.length;
        int index = 0;
        
        Node root = new Node(Integer.valueOf(str[index++]), new ArrayList<Node>());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty() && index < length) {
        	Node node = queue.poll();
        	index++; // note: 取一个新的root，直接++，否则遇到#
        	while(index < length && !str[index].equals("#")) {
        		if(!str[index].equals("null")) {
        			Node child = new Node(Integer.valueOf(str[index]), new ArrayList<Node>());
        			node.children.add(child);
        			queue.offer(child);
        			index++;
        		}
        		else {
        			index++;
        		}
        	}
        }
        return root;
    }
    
    public static void main(String[] args) {
    	Node node1 = new Node(1, new ArrayList<Node>());
    	Node node2 = new Node(2, new ArrayList<Node>());
    	Node node3 = new Node(3, new ArrayList<Node>());
    	Node node4 = new Node(4, new ArrayList<Node>());
    	Node node5 = new Node(5, new ArrayList<Node>());
    	Node node6 = new Node(6, new ArrayList<Node>());
    	
    	node1.children.add(node3);
    	node1.children.add(node2);
    	node1.children.add(node4);
    	
    	node2.children.add(node5);
    	node2.children.add(node6);
    	
    	System.out.println(serialize(node1));
    	System.out.println(serialize(deserialize("1 # 3 2 4 # # # 5 6 # ")));
    }
}
