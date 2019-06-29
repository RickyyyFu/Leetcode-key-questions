package LC_642_Design_Search_Autocomplete_System;

import java.util.*;

public class AutocompleteSystem_Trie {
	class TrieNode{
		Map<Character, TrieNode> children;
		Map<String, Integer> freq; // the times of the sentence including the char
		
		TrieNode(){
			children = new HashMap<>();
			freq = new HashMap<>();
		}
	}
	
	class Pair{
		String str;
		int time;
		
		Pair(String str, int time){
			this.str = str;
			this.time = time;
		}
	}
	
	void insert(String sentence, int time) {
		TrieNode cur = root;
		for(char c : sentence.toCharArray()) {
			if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
			cur = cur.children.get(c);
			if(!cur.freq.containsKey(sentence)) {
				cur.freq.put(sentence, time);
			}
			else {
				int freq = cur.freq.get(sentence) + time;
				cur.freq.put(sentence, freq);
			}
			
		}
	}
	
	TrieNode root;
	String str;
	
	public AutocompleteSystem_Trie(String[] sentences, int[] times) {
		root = new TrieNode();
		str = "";
		
		for(int i = 0; i < times.length; i++) {
			insert(sentences[i], times[i]);
		}
	}
	
	public List<String> input(char c) {
		if(c == '#') {
			insert(str, 1);
			str = "";
			
			return new ArrayList<String>();
		}
		
		str += c;
		// search prefix
		TrieNode cur = root;
		for(char ch : str.toCharArray()) {
			// i don't love -> no historical
			if(!cur.children.containsKey(ch)) return new ArrayList<String>(); 
			cur = cur.children.get(ch);
		}
		
		// 最小堆 time从小到大 word从z到a 
		// LAMBDA!!!
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> (a.time == b.time ? b.str.compareTo(a.str) : a.time-b.time));
		for(String s : cur.freq.keySet()) {
			minHeap.offer(new Pair(s, cur.freq.get(s)));
			if(minHeap.size() > 3) minHeap.poll();
		}
		
		List<String> res = new ArrayList<>();
		while(!minHeap.isEmpty()) {
			res.add(0, minHeap.poll().str);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] ss = {"i love you","island","ironman","i love leetcode"};
		int[] tt = {5,3,2,2};
		AutocompleteSystem_Trie au = new AutocompleteSystem_Trie(ss, tt);
		System.out.println(au.input('i'));
		System.out.println(au.input(' '));
		System.out.println(au.input('a'));
		System.out.println(au.input('#'));
		System.out.println(au.input('i'));
		System.out.println(au.input(' '));
		System.out.println(au.input('a'));
	}
}