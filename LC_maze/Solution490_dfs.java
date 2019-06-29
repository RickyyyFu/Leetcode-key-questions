package LC_maze;

public class Solution490_dfs {
	
	    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
	        int m = maze.length, n = maze[0].length;
	        boolean[][] visited = new boolean[m][n];
	        return dfs(maze, visited, start, destination);
	    }
	    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
	        int row = start[0], col = start[1];
	        
	        //check boundaries and if the point visited before
	        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col]) return false;
	        
	        //mark as a visited stop point
	        visited[row][col] = true;
	        
	        //if stop point is destination => true
	        if (row == destination[0] && col == destination[1]) return true;
	        
	        //DFS on four directions
	        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	        for (int i = 0; i < 4; i++) {
	            int x = row, y = col;
	            
	            //rolling until out or hit the wall 
	            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1) {
	                x += dirs[i][0];
	                y += dirs[i][1];
	            }
	            
	            //back to the stop point
	            x -= dirs[i][0];
	            y -= dirs[i][1];
	            
	            //start another dfs from the stop point
	            if (dfs(maze, visited, new int[]{x, y}, destination)) return true;
	        }
	        return false;
	    }
	

}
