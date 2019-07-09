package LC_489_Robot_Room_Cleaner;

import java.util.*;

public class Solution {
	//  public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 必须依次向右转
  
	public void cleanRoom(Robot robot) {
		Set<String> visited = new HashSet<>();
		dfs(robot, 0, 0, visited, 0);
	}
  
	void dfs(Robot robot, int row, int col, Set<String> visited, int dir){
		String pos = row + "," + col;
      
		if(!visited.contains(pos)){
			visited.add(pos);
			robot.clean();
          
			for(int i = dir; i < dir+4; i++){ // dir为朝向， 保持朝向move，move不行或者一次dfs完成后右转
				if(robot.move()){
					dfs(robot, row + dirs[i%4][0], col + dirs[i%4][1], visited, i%4);
                  
					// backtracking
					robot.turnRight();
					robot.turnRight();
					robot.move();
					robot.turnRight();
					robot.turnRight();
				}
              
				robot.turnRight();
			}
		}
	}
}
