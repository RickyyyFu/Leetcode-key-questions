package LC_211_Add_and_Search_Word;

import java.util.*;

class WordDictionary {
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWord;
        
        TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
            this.isWord = false;
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode node) {        
        TrieNode cur = node;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                if(cur.children.keySet().isEmpty()) return false; // insert(a)  search(a.) -> false
                
                for(char key : cur.children.keySet()){
                	TrieNode temp = cur.children.get(key);
                    if(search(word.substring(i+1), temp) == true) return true;
                }
                return false;
            }else{
                if(!cur.children.containsKey(c)) return false;
                cur = cur.children.get(c);
            }
        }
        return cur.isWord;
    }
    
    public static void main(String[] args) {
    	WordDictionary obj = new WordDictionary();
    	obj.addWord("at");
    	obj.addWord("and");
    	obj.addWord("an");
    	obj.addWord("add");
    	obj.addWord("bat");
    	System.out.println(obj.search("a"));
    	System.out.println(obj.search("bat"));
//    	obj.addWord("bat");
    	System.out.println(obj.search(".at"));
    	System.out.println(obj.search("an."));
    	System.out.println(obj.search("a.d."));
    	System.out.println(obj.search("b."));
    	System.out.println(obj.search("a.d"));
    	System.out.println(obj.search("."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
