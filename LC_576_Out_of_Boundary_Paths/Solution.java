package LC_576_Out_of_Boundary_Paths;

public class Solution {
    int count = 0;
    public int findPaths(int m, int n, int N, int i, int j) {
        dfs(m, n, N, i, j, 0);
        return count;
    }
    
    void dfs(int m, int n, int N, int i, int j, int k){
        if(k > N) return;
        
        if(i < 0 || i >= m || j < 0 || j >= n){
            count++;
            return;
        }
        
        dfs(m, n, N, i-1, j, k+1);
        dfs(m, n, N, i+1, j, k+1);
        dfs(m, n, N, i, j-1, k+1);
        dfs(m, n, N, i, j+1, k+1);
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.findPaths(1, 3, 3, -1, 1));
    }
}
