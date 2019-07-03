/*
package LC_702_Search_in_a_Sorted_Array_of_Unknown_Size;

import java.util.*;
import ArrayReader.*;

public class Solution {
	public int search(ArrayReader reader, int target) {
		int right = 1;
		while(reader.get(right) != Integer.MAX_VALUE && reader.get(right) < target) {
			right *= 2;
		}
		int left = right / 2;
		
		while(left <= right){
			int mid = left + (right - left)/2;
            int val = reader.get(mid);
            if(val == target) return mid;
            else if(val > target) right = mid -1;
            else left = mid + 1;
        }
        return -1;     
	}
}




class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int left = 0, right = INT_MAX;
        while (left < right) {
            int mid = left + (right - left) / 2, x = reader.get(mid);
            if (x == target) return mid;
            else if (x < target) left = mid + 1;
            else right = mid;
        }
        return -1;
    }
};
**/
