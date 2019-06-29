package LC_286_Walls_and_Gates;

public class DFS {
	public void wallsAndGates(int[][] rooms) {
		for(int i = 0; i < rooms.length; i++) {
			for(int j = 0; j < rooms[i].length; j++) {
				if(rooms[i][j] == 0) {
					dfs(rooms, i, j, 0);
				}
			}
		}
	}
	
	void dfs(int[][] rooms, int i, int j, int val) {
		if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[i].length || rooms[i][j] == -1) return;
		
		if(val < rooms[i][j]) rooms[i][j] = val;
		
		dfs(rooms, i+1, j, val+1);
		dfs(rooms, i-1, j, val+1);
		dfs(rooms, i, j+1, val+1);
		dfs(rooms, i, j-1, val+1);
	}
}
