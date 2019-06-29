package LC_269_Alien_Dictionary;

import java.util.*;

// https://www.youtube.com/watch?v=1TRM9KFdr4o
//http://rainykat.blogspot.com/2017/01/leetcode-269-alien-dictionarybfs.html

// bfs
public class Solution {
	public static String alienOrder(String[] words) {
		if(words == null || words.length == 0) return "";
		int[] degree = new int[26];
		
		HashMap<Character, Set<Character>> map = new HashMap<>();
		buildGraph(words, map);
		
		StringBuilder sb = new StringBuilder();
		bfs(map, sb);
		return sb.toString();
	}
	
	private static void bfs(HashMap<Character, Set<Character>> map, StringBuilder sb) {
		
	}
	
	private static void buildGraph(String[] words, HashMap<Character, Set<Character>> map, int[] degree) {
		for(int i = 0; i < words.length-1; i++) {
			String w1 = words[i];
			String w2 = words[i+1];
			int length = Math.min(w1.length(), w2.length());
			
			
		}

		
		StringBuilder res = new StringBuilder();
		
		
		int count = 0;
		
		
		
		
		
		

	}
}
