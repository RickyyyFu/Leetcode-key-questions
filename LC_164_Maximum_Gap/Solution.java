package LC_164_Maximum_Gap;

import java.util.Arrays;

// 桶排序 bucket
// https://www.youtube.com/watch?v=U466HbSf8DQ
public class Solution {
	public static int maximumGap (int[] nums) {
		if(nums.length <=1) return 0;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		int gap = (int)Math.ceil((double)(max-min)/(double)(nums.length-1));
		if(gap == 0) return 0;
		
		int size = (max - min)/gap + 1;
		int[] bucketMax = new int[size];
		int[] bucketMin = new int[size];
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		
		for(int i = 0; i < nums.length; i++) {
			int index = (nums[i] - min)/gap;
			bucketMin[index] = Math.min(bucketMin[index], nums[i]);
			bucketMax[index] = Math.max(bucketMax[index], nums[i]);
		}
		
		for(int i = 0; i < size; i++) {
			if(bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) {
				continue;
			}
			gap = Math.max(gap, bucketMin[i] - min);
			min = bucketMax[i];
		}
		return gap;
	}
}
