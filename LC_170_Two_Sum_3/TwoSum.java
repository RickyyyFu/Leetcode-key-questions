package LC_170_Two_Sum_3;

import java.util.*;

public class TwoSum {
	Map<Integer, Integer> map = new HashMap<>();
	
	void add(int number) {
		 map.put(number, map.getOrDefault(number, 0)+1);
	}
	 
	boolean find(int value) {
		 for(int n : map.keySet()) {
			 int diff = value - n;
			 if(diff == n && map.get(n) > 1) return true;
			 if(diff != n && map.containsKey(diff)) return true;
		 }
		 return false;
	}
	
	public static void main(String[] args) {
		TwoSum s = new TwoSum();
		s.add(1);
		s.add(3);
		s.add(5);
		System.out.println(s.find(4));
		System.out.println(s.find(7));
	}
}
