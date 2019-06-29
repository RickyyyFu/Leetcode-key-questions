package LC_288_Unique_Word_Abbreviation;

import java.util.*;

public class ValidWordAbbr {
	Map<String, Set<String>> map = new HashMap<>();
	
	public ValidWordAbbr(String[] dictionary) {
		for(String word : dictionary) {
			String abbr = word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1);
			if(map.containsKey(abbr)) {
				map.get(abbr).add(word);
			}
			else {
				Set<String> set = new HashSet<>();
				set.add(word);
				map.put(abbr, set);
			}
		}
	}
	
	public boolean isUnique(String word) {
		String abbr = word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1);
		if(!map.containsKey(abbr)) {
			return true;
		}
		else {
			if(map.get(abbr).contains(word) && map.get(abbr).size() == 1) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[] d1 = {"deer", "door", "cake", "card"};
		ValidWordAbbr v1 = new ValidWordAbbr(d1);
		System.out.println(v1.isUnique("dear"));  // false
		System.out.println(v1.isUnique("cart"));  // true
		System.out.println(v1.isUnique("cane"));  // false
		System.out.println(v1.isUnique("make"));  // true
		
		String[] d2 = {"deer"};
		ValidWordAbbr v2 = new ValidWordAbbr(d2);
		System.out.println(v2.isUnique("dear"));  // false

		String[] d3 = {"door", "door"};
		ValidWordAbbr v3 = new ValidWordAbbr(d3);
		System.out.println(v3.isUnique("door"));  // true
		
		String[] d4 = {"dear", "door"};
		ValidWordAbbr v4 = new ValidWordAbbr(d4);
		System.out.println(v4.isUnique("door"));  // false
	}
}
