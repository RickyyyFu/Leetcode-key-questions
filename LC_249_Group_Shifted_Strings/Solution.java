package LC_249_Group_Shifted_Strings;

import java.util.*;

public class Solution {
	// 用a开头的string作为key
	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strings) {
			char[] chars = str.toCharArray();
			int diff = chars[0] - 'a';
			for(int i = 0; i < chars.length; i++) {
				if(chars[i] - diff < 'a') {
					chars[i] = (char) (chars[i] - diff + 26);
				}
				else {
					chars[i] = (char) (chars[i] - diff);
				}
			}
			String key = new String(chars);
			if(!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
			else {
				map.get(key).add(str);
			}
		}
		
		List<List<String>> res = new ArrayList<>();
		for(String key : map.keySet()) {
			res.add(new ArrayList<>(map.get(key)));
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] strings = {"a","z","abc","az","ba","bcd","acef","xyz"};
		System.out.println(s.groupStrings(strings));
	}
}
