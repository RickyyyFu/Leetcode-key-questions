package LC_200_Number_of_Islands;

//dfs
public class Solution {
 public int numIslands(char[][] grid) {
     int total = 0;
     for(int i=0;i<grid.length;i++){
         for(int j=0;j<grid[0].length;j++){
             if(grid[i][j]=='1'){
                 total++;
                 dfs(grid,i,j);
             }
         }
     }   
     return total;
 }
 
 public void dfs(char[][] grid, int row, int col){
     if(row<0 || row==grid.length || col<0 || col==grid[0].length || grid[row][col]!='1')
         return;
     
     grid[row][col]='2';
     dfs(grid,row-1,col); 
     dfs(grid,row+1,col);
     dfs(grid,row,col-1);
     dfs(grid,row,col+1);
 }
}