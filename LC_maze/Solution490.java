package LC_maze;

// dfs bfs https://segmentfault.com/a/1190000017163338

import java.util.*;

public class Solution490 {
	    // 1. bfs, create a queue, add start
	    // 2. try all 4 directions, stop until hit out of border or 1
	    // 3. put last valid pos to the queue
	    // 4. mark the pos as visited (can NOT change the maze)
	    // 5. loop until queue is empty
	    // 6. during any queue.poll(), if it's destination, return true
	    // 7. if loop is finished, return false
	    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
	        boolean[][] visited = new boolean[maze.length][maze[0].length];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(start);
	        visited[start[0]][start[1]] = true;
	        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}}; //四个方向
	        
	        
	        while(queue.size() > 0) {
	            int[] pos = queue.poll(); // 取出一个值returns and removes 
	            if(pos[0] == dest[0] && pos[1] == dest[1]) {
	                return true;
	            }
	            for(int k = 0; k < dirs.length; ++k) {  // 分别向上下左右探索可达到的位置
	                int x = pos[0] + dirs[k][0]; // 移动一次后的位置
	                int y = pos[1] + dirs[k][1];
	                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) { // 朝一个方向一直移动
	                    x += dirs[k][0];
	                    y += dirs[k][1];
	                }
	                x -= dirs[k][0]; // 回到前一个状态
	                y -= dirs[k][1];
	                if(!visited[x][y]) { 
	                    queue.add(new int[]{x,y}); // 将为到达过的位置加入队列，为之后探索的起点
	                    visited[x][y] = true; 
	                }
	            }    
	        }
	        return false;
	    }
	
}
