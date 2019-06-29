package LC_452_Word_Squares;

import java.util.*;

public class Solution {
	
	class TrieNode{
		Map<Character, TrieNode> children;
		List<String> prefixOf;
		
		TrieNode(){
			children = new HashMap<>();
			prefixOf = new ArrayList<>();
		}
	}
	
	void insert(String word) {
		TrieNode cur = root;
		for(char c : word.toCharArray()) {
			if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
			cur = cur.children.get(c);
			cur.prefixOf.add(word);
		}
	}
	
	List<String> findByPrefix(String prefix){
		List<String> res = new ArrayList<>();
		TrieNode cur = root;
		for(char c : prefix.toCharArray()) {
			if(!cur.children.containsKey(c)) return res;
			cur = cur.children.get(c);
		}
		res.addAll(cur.prefixOf);
		return res;
	}
	
	TrieNode root;
	
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> ans = new ArrayList<>();
		if(words == null || words.length == 0) return ans;
		
		root = new TrieNode();
		for(String word : words) {
			insert(word);
		}
		
		List<String> ansBuilder = new ArrayList<>();  // one answer
		// 将每个单词作为第一个，向下寻找下一个单词
		for(String word : words) {
			int length = word.length(); // the length of first word in the square is the number of string in one answer (answerBuilder.size)
			ansBuilder.add(word);
			dfs(length, ansBuilder, ans);
			ansBuilder.remove(ansBuilder.size()-1);
		}
		return ans;
	}
	
	void dfs(int length, List<String> ansBuilder, List<List<String>> ans) {
		if(ansBuilder.size() == length) {
			ans.add(new ArrayList<>(ansBuilder)); // not use reference, copy ansBuilder, because it will change
			return;
		}
		
		// 现在andB里有x个string, 要找第x+1个string, 则它的prefix为之前string的第x位
		int index = ansBuilder.size();
		StringBuilder prefixBuilder = new StringBuilder();
		for(String str : ansBuilder) {
			prefixBuilder.append(str.charAt(index));
		}
		String prefix = prefixBuilder.toString();
		
		// 在trie里找到所有以prefix位前缀的单词
		List<String> prefixOfWords = findByPrefix(prefix);
		// 把它们分别加到ansBuilder里，再继续dfs，直到ansBuilder.size() == length
		for(String s : prefixOfWords) {
			ansBuilder.add(s);
			dfs(length, ansBuilder, ans);
			ansBuilder.remove(ansBuilder.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] s1 = {"area","lead","wall","lady","ball"};
		System.out.println(s.wordSquares(s1));
		String[] s2 = {"abat","baba","atan","atal"};
		System.out.println(s.wordSquares(s2));
	}
}
