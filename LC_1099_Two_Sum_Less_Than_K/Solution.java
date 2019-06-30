package LC_1099_Two_Sum_Less_Than_K;

import java.util.Arrays;

class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        while(i < j){
            if(A[i] + A[j] < K){
                res = Math.max(res, A[i] + A[j]);
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] a1 = {1,2,3,4,5,60};
    	System.out.println(s.twoSumLessThanK(a1, 70));
    	int[] a2 = {10,20,30};
    	System.out.println(s.twoSumLessThanK(a2, 15));
    }
}
