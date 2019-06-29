package LC_539_01Matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.*;

// 暴力
// dp
// dfs???
// bfs

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1){
                    // 每个点都要求最小路径
                    bfs(matrix, i ,j, res);
                }
            }
        }
        return res;
    }         
    
    void bfs(int[][] matrix, int i, int j, int[][] res){
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        int pos = i*cols + j;
        q.offer(pos);
        visited.add(pos);
        int step = 0; // note!!!
                    
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                int _pos = q.poll();
                int m = _pos/cols;
                int n = _pos%cols;
                            
                if(matrix[m][n] == 0){
                    res[i][j] = step;
                    size--;
                    return;  // note!!!!
                }
                            
                if(m-1 >= 0 && !visited.contains((m-1)*cols+n)){
                    int p = (m-1)*cols + n;
                    q.offer(p);
                    visited.add(p);
                }
                if(m+1 < rows && !visited.contains((m+1)*cols+n)){
                    int p = (m+1)*cols + n;
                    q.offer(p);
                    visited.add(p);
                }
                if(n-1 >= 0 && !visited.contains(m*cols+n-1)){
                    int p = m*cols + n-1;
                    q.offer(p);
                    visited.add(p);
                }
                if(n+1 < cols && !visited.contains(m*cols+n+1)){
                    int p = m*cols + n+1;
                    q.offer(p);
                    visited.add(p);
                }
            
                size--;
            }
            step++;
        }
    }
}